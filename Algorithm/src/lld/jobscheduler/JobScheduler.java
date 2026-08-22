package lld.jobscheduler;

import java.util.*;
import java.util.concurrent.*;

public class JobScheduler {

  private final PriorityQueue<Job> queue; // Jobs waiting to be executed. Earliest executeAt comes first.
  private final Map<String, Job> jobs;
  private final Map<String, Future<?>> runningJobs; // Stores currently running jobs. Used for cancellation.
  private final ExecutorService executorService;  // Worker threads actually execute the jobs.
  private final Object lock = new Object();  // Lock used for queue + job state operations.
  private final Thread schedulerThread;  // Scheduler thread continuously looks for the next job to execute.
  private volatile boolean shutdown;

  public JobScheduler() {
    this(3);
  }

  public JobScheduler(int threadPoolSize) {
    if (threadPoolSize <= 0) {
      throw new IllegalArgumentException("Thread pool size must be greater than zero");
    }
    this.queue = new PriorityQueue<>(Comparator.comparingLong(Job::getExecuteAt));
    this.jobs = new HashMap<>();
    this.runningJobs = new HashMap<>();
    this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    this.shutdown = false;
    this.schedulerThread = new Thread(this::processJobs, "job-scheduler");
    this.schedulerThread.start();
  }

  public void schedule(Job job) {
    synchronized (lock) {
      if (shutdown) {
        throw new IllegalStateException("Scheduler is shut down");
      }
      if (jobs.containsKey(job.getId())) {
        throw new IllegalArgumentException("Job already exists: " + job.getId());
      }
      job.setStatus(JobStatus.SCHEDULED);
      jobs.put(job.getId(), job);
      queue.offer(job);
      lock.notifyAll();
    }
  }

  public boolean cancel(String jobId) {
    synchronized (lock) {
      Job job = jobs.get(jobId);
      if (job == null) {
        return false;
      }
      if (job.getStatus() == JobStatus.COMPLETED || job.getStatus() == JobStatus.FAILED || job.getStatus() == JobStatus.CANCELLED) {
        return false;
      }
      if (job.getStatus() == JobStatus.SCHEDULED) {
        queue.remove(job);
        job.setStatus(JobStatus.CANCELLED);
        lock.notifyAll();
        return true;
      }
      if (job.getStatus() == JobStatus.RUNNING) {
        job.setStatus(JobStatus.CANCELLED);
        Future<?> future = runningJobs.get(jobId);
        if (future != null) {
          future.cancel(true);
        }
        return true;
      }
      return false;
    }
  }

  public boolean reschedule(String jobId, long newExecuteAt) {
    synchronized (lock) {
      Job job = jobs.get(jobId);
      if (job == null) {
        return false;
      }
      if (job.getStatus() != JobStatus.SCHEDULED) {
        return false;
      }
      queue.remove(job);
      job.setExecuteAt(newExecuteAt);
      queue.offer(job);
      lock.notifyAll();
      return true;
    }
  }

  public JobStatus getStatus(String jobId) {
    synchronized (lock) {
      Job job = jobs.get(jobId);
      if (job == null) {
        return null;
      }
      return job.getStatus();
    }
  }

  public Job getJob(String jobId) {
    synchronized (lock) {
      return jobs.get(jobId);
    }
  }

  private void processJobs() {
    while (true) {
      Job job;
      synchronized (lock) {
        while (queue.isEmpty()) {
          if (shutdown) {
            executorService.shutdown();
            return;
          }
          try {
            lock.wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
          }
        }
        job = queue.peek();
        long delay = job.getExecuteAt() - System.currentTimeMillis();
        if (delay > 0) {
          try {
            lock.wait(delay);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
          }
          continue;
        }
        queue.poll();
        if (job.getStatus() == JobStatus.CANCELLED) {
          continue;
        }
        job.setStatus(JobStatus.RUNNING);
      }
      execute(job);
    }
  }

  private void execute(Job job) {
    Future<?> future = executorService.submit(() -> {
          try {
            job.getTask().run();
            synchronized (lock) {
              if (job.getStatus() != JobStatus.CANCELLED) {
                job.setStatus(JobStatus.COMPLETED);
              }
              runningJobs.remove(job.getId());
            }
          } catch (Throwable e) {
            handleFailure(job, e);
          }
        });
    synchronized (lock) {
      // Job might have been cancelled between submission and this block.
      if (job.getStatus() == JobStatus.CANCELLED) {
        future.cancel(true);
      } else {
        runningJobs.put(job.getId(), future);
      }
    }
  }

  // Handle failed job.
  private void handleFailure(Job job, Throwable error) {
    synchronized (lock) {
      runningJobs.remove(job.getId());
      // Job was explicitly cancelled.
      if (job.getStatus() == JobStatus.CANCELLED) {
        return;
      }
      job.setError(error);
      // Retry if possible.
      if (job.getRetryCount() < job.getMaxRetries()) {
        job.incrementRetryCount();
        long retryDelay = calculateRetryDelay(job.getRetryCount());
        job.setExecuteAt(System.currentTimeMillis() + retryDelay);
        job.setStatus(JobStatus.SCHEDULED);
        queue.offer(job);
        lock.notifyAll();
      } else {
        job.setStatus(JobStatus.FAILED);
      }
    }
  }

  /**
   * Exponential backoff.
   * Retry 1 -> 1 second
   * Retry 2 -> 2 seconds
   * Retry 3 -> 4 seconds
   * Retry 4 -> 8 seconds
   */
  private long calculateRetryDelay(int retryCount) {
    long delay = 1000L;
    for (int i = 1; i < retryCount; i++) {
      delay *= 2;
      if (delay >= 60_000L) {   // Prevent overflow / extremely large delay.
        return 60_000L;
      }
    }
    return delay;
  }

  /**
   * Graceful shutdown.
   * - Stops accepting new jobs
   * - Existing queued jobs are processed
   * - Running jobs are allowed to finish
   */
  public void shutdown() {
    synchronized (lock) {
      shutdown = true;
      lock.notifyAll();  // Wake scheduler if it is waiting.
    }
  }

  /**
   * Immediate shutdown.
   * - Stops scheduler
   * - Clears waiting jobs
   * - Attempts to interrupt running jobs
   */
  public void shutdownNow() {
    synchronized (lock) {
      shutdown = true;
      /*
       * Cancel queued jobs.
       */
      for (Job job : queue) {
        job.setStatus(JobStatus.CANCELLED);
      }
      queue.clear();
      /*
       * Cancel running jobs.
       */
      for (Job job : jobs.values()) {
        if (job.getStatus() == JobStatus.RUNNING) {
          job.setStatus(JobStatus.CANCELLED);
        }
      }
      for (Future<?> future : runningJobs.values()) {
        future.cancel(true);
      }
      runningJobs.clear();
      lock.notifyAll();
    }
    schedulerThread.interrupt();
    executorService.shutdownNow();
  }
}
