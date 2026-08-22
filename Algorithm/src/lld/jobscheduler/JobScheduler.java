package lld.jobscheduler;

import java.util.*;
import java.util.concurrent.*;

public class JobScheduler {

  /*
   * Jobs waiting to be executed.
   *
   * Earliest executeAt comes first.
   */
  private final PriorityQueue<Job> queue;

  /*
   * Stores all jobs by ID.
   *
   * Useful for:
   * - getStatus()
   * - cancel()
   * - reschedule()
   */
  private final Map<String, Job> jobs;

  /*
   * Stores currently running jobs.
   *
   * Used for cancellation.
   */
  private final Map<String, Future<?>> runningJobs;

  /*
   * Worker threads actually execute the jobs.
   */
  private final ExecutorService executorService;

  /*
   * Lock used for queue + job state operations.
   */
  private final Object lock = new Object();

  /*
   * Scheduler thread continuously looks for
   * the next job to execute.
   */
  private final Thread schedulerThread;

  private volatile boolean shutdown;

  public JobScheduler() {
    this(3);
  }

  public JobScheduler(int threadPoolSize) {

    if (threadPoolSize <= 0) {
      throw new IllegalArgumentException(
          "Thread pool size must be greater than zero");
    }

    this.queue = new PriorityQueue<>(
        Comparator.comparingLong(Job::getExecuteAt)
    );

    this.jobs = new HashMap<>();

    this.runningJobs = new HashMap<>();

    this.executorService =
        Executors.newFixedThreadPool(threadPoolSize);

    this.shutdown = false;

    this.schedulerThread =
        new Thread(this::processJobs, "job-scheduler");

    this.schedulerThread.start();
  }

  /**
   * Schedule a new job.
   */
  public void schedule(Job job) {

    synchronized (lock) {

      if (shutdown) {
        throw new IllegalStateException(
            "Scheduler is shut down");
      }

      if (jobs.containsKey(job.getId())) {
        throw new IllegalArgumentException(
            "Job already exists: " + job.getId());
      }

      job.setStatus(JobStatus.SCHEDULED);

      jobs.put(job.getId(), job);

      queue.offer(job);

      /*
       * Wake up scheduler.
       *
       * Important when a newly added job has an
       * earlier executeAt than the current job.
       */
      lock.notifyAll();
    }
  }

  /**
   * Cancel a job.
   *
   * Cancellation can happen:
   *
   * 1. Before execution
   * 2. While running
   */
  public boolean cancel(String jobId) {

    synchronized (lock) {

      Job job = jobs.get(jobId);

      if (job == null) {
        return false;
      }

      if (job.getStatus() == JobStatus.COMPLETED ||
          job.getStatus() == JobStatus.FAILED ||
          job.getStatus() == JobStatus.CANCELLED) {

        return false;
      }

      /*
       * Job hasn't started yet.
       */
      if (job.getStatus() == JobStatus.SCHEDULED) {

        queue.remove(job);

        job.setStatus(JobStatus.CANCELLED);

        lock.notifyAll();

        return true;
      }

      /*
       * Job is currently running.
       */
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

  /**
   * Reschedule a job.
   *
   * Only SCHEDULED jobs can be rescheduled.
   */
  public boolean reschedule(
      String jobId,
      long newExecuteAt) {

    synchronized (lock) {

      Job job = jobs.get(jobId);

      if (job == null) {
        return false;
      }

      if (job.getStatus() != JobStatus.SCHEDULED) {
        return false;
      }

      /*
       * Remove old entry.
       */
      queue.remove(job);

      /*
       * Change execution time.
       */
      job.setExecuteAt(newExecuteAt);

      /*
       * Add again so PriorityQueue can
       * reorder it.
       */
      queue.offer(job);

      lock.notifyAll();

      return true;
    }
  }

  /**
   * Get current status of a job.
   */
  public JobStatus getStatus(String jobId) {

    synchronized (lock) {

      Job job = jobs.get(jobId);

      if (job == null) {
        return null;
      }

      return job.getStatus();
    }
  }

  /**
   * Get complete job information.
   */
  public Job getJob(String jobId) {

    synchronized (lock) {
      return jobs.get(jobId);
    }
  }

  /**
   * Scheduler thread.
   *
   * Continuously picks the earliest job.
   */
  private void processJobs() {

    while (true) {

      Job job;

      synchronized (lock) {

        /*
         * Graceful shutdown:
         *
         * Don't accept new jobs.
         * Finish processing existing queued jobs.
         */
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

        long delay =
            job.getExecuteAt() -
                System.currentTimeMillis();

        /*
         * Job is scheduled for the future.
         */
        if (delay > 0) {

          try {

            /*
             * Wait only until the next job
             * should execute.
             *
             * notifyAll() can wake us earlier
             * if a new earlier job is added.
             */
            lock.wait(delay);

          } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            return;
          }

          continue;
        }

        /*
         * Remove job from queue.
         */
        queue.poll();

        /*
         * Check if it was cancelled while
         * waiting.
         */
        if (job.getStatus() == JobStatus.CANCELLED) {
          continue;
        }

        job.setStatus(JobStatus.RUNNING);
      }

      /*
       * Do NOT execute while holding lock.
       */
      execute(job);
    }
  }

  /**
   * Submit job to worker thread pool.
   */
  private void execute(Job job) {

    Future<?> future =
        executorService.submit(() -> {

          try {

            job.getTask().run();

            /*
             * If cancellation happened while
             * task was running, don't overwrite
             * CANCELLED with COMPLETED.
             */
            synchronized (lock) {

              if (job.getStatus() !=
                  JobStatus.CANCELLED) {

                job.setStatus(
                    JobStatus.COMPLETED);
              }

              runningJobs.remove(job.getId());
            }

          } catch (Throwable e) {

            handleFailure(job, e);
          }
        });

    synchronized (lock) {

      /*
       * Job might have been cancelled between
       * submission and this block.
       */
      if (job.getStatus() == JobStatus.CANCELLED) {

        future.cancel(true);

      } else {

        runningJobs.put(job.getId(), future);
      }
    }
  }

  /**
   * Handle failed job.
   */
  private void handleFailure(
      Job job,
      Throwable error) {

    synchronized (lock) {

      runningJobs.remove(job.getId());

      /*
       * Job was explicitly cancelled.
       */
      if (job.getStatus() == JobStatus.CANCELLED) {
        return;
      }

      job.setError(error);

      /*
       * Retry if possible.
       */
      if (job.getRetryCount() <
          job.getMaxRetries()) {

        job.incrementRetryCount();

        long retryDelay =
            calculateRetryDelay(
                job.getRetryCount());

        job.setExecuteAt(
            System.currentTimeMillis()
                + retryDelay);

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
   *
   * Retry 1 -> 1 second
   * Retry 2 -> 2 seconds
   * Retry 3 -> 4 seconds
   * Retry 4 -> 8 seconds
   */
  private long calculateRetryDelay(int retryCount) {

    long delay = 1000L;

    for (int i = 1; i < retryCount; i++) {

      delay *= 2;

      /*
       * Prevent overflow / extremely large delay.
       */
      if (delay >= 60_000L) {
        return 60_000L;
      }
    }

    return delay;
  }

  /**
   * Graceful shutdown.
   *
   * - Stops accepting new jobs
   * - Existing queued jobs are processed
   * - Running jobs are allowed to finish
   */
  public void shutdown() {

    synchronized (lock) {

      shutdown = true;

      /*
       * Wake scheduler if it is waiting.
       */
      lock.notifyAll();
    }
  }

  /**
   * Immediate shutdown.
   *
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

        if (job.getStatus() ==
            JobStatus.RUNNING) {

          job.setStatus(JobStatus.CANCELLED);
        }
      }

      for (Future<?> future :
          runningJobs.values()) {

        future.cancel(true);
      }

      runningJobs.clear();

      lock.notifyAll();
    }

    schedulerThread.interrupt();

    executorService.shutdownNow();
  }
}