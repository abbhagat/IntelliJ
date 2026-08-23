package lld.jobscheduler;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {

  private final PriorityQueue<Job> queue;
  private final Map<String, Job> jobs;
  private final ExecutorService executor;
  private final Object lock;
  private       boolean shutdown;

  public JobScheduler() {
    this.queue    = new PriorityQueue<>(Comparator.comparingLong(Job::getExecuteAt)); // min heap so the job with the smaller executeAt gets higher priority.
    this.jobs     = new ConcurrentHashMap<>();
    this.executor = Executors.newFixedThreadPool(3);
    this.lock     = new Object();
    this.shutdown = false;
    Thread thread = new Thread(this::processJobs);
    thread.start();
  }

  // Schedule
  public void schedule(Job job) {
    synchronized (lock) {
      if (shutdown) {
        throw new IllegalStateException("Scheduler is shutdown");
      }
      if (jobs.containsKey(job.getId())) {
        throw new IllegalArgumentException("Job already exists");
      }
      jobs.put(job.getId(), job);
      queue.offer(job);
      lock.notifyAll();
    }
  }

  // Cancel
  public boolean cancel(String jobId) {
    synchronized (lock) {
      Job job = jobs.get(jobId);
      if (job == null || job.getStatus() != JobStatus.SCHEDULED) {
        lock.notifyAll();
        return false;
      }
      queue.remove(job);
      job.setStatus(JobStatus.CANCELLED);
      lock.notifyAll();
      return true;
    }
  }

  // Reschedule
  public boolean reschedule(String jobId, long newExecuteAt) {
    synchronized (lock) {
      Job job = jobs.get(jobId);
      if (job == null || job.getStatus() != JobStatus.SCHEDULED) {
        lock.notifyAll();
        return false;
      }
      queue.remove(job);
      job.setExecuteAt(newExecuteAt);
      job.setStatus(JobStatus.SCHEDULED);
      queue.offer(job);
      lock.notifyAll();
      return true;
    }
  }

  // Get status
  public JobStatus getStatus(String jobId) {
    synchronized (lock) {
      Job job = jobs.get(jobId);
      lock.notifyAll();
      return job == null ? null : job.getStatus();
    }
  }

  // Scheduler thread
  private void processJobs() {
    while (true) {
      Job job;
      synchronized (lock) {
        while (!shutdown && queue.isEmpty()) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            return;
          }
        }
        if (shutdown && queue.isEmpty()) {
          executor.shutdown();
          return;
        }
        job = queue.peek();
        long delay = job.getExecuteAt()  - System.currentTimeMillis();
        if (delay > 0) {
          try {
            lock.wait(delay);
          } catch (InterruptedException e) {
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

  // Execute job
  private void execute(Job job) {
    executor.submit(() -> {
      try {
        job.getTask().run();
        synchronized (lock) {
          job.setStatus(JobStatus.COMPLETED);
        }
      } catch (Exception e) {
        retry(job);
      }
    });
  }

  // Retry failed job
  private void retry(Job job) {
    synchronized (lock) {
      if (job.getRetryCount() < job.getMaxRetry()) {
        job.incrementRetry();
        job.setExecuteAt(System.currentTimeMillis() + 1000);  // Retry after 1 second
        job.setStatus(JobStatus.SCHEDULED);
        queue.offer(job);
        lock.notifyAll();
      } else {
        job.setStatus(JobStatus.FAILED);
      }
    }
  }

  public void shutdown() {
    synchronized (lock) {
      shutdown = true;
      lock.notifyAll();
    }
  }
}
