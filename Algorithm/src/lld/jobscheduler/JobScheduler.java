package lld.jobscheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {

  private final PriorityQueue<Job> queue =
      new PriorityQueue<>(
          (a, b) -> Long.compare(
              a.getExecuteAt(),
              b.getExecuteAt()
          )
      );

  private final Map<String, Job> jobs = new HashMap<>();

  private final ExecutorService executor =
      Executors.newFixedThreadPool(3);

  private final Object lock = new Object();

  private boolean shutdown = false;

  public JobScheduler() {
    new Thread(this::processJobs).start();
  }

  // Schedule
  public void schedule(Job job) {

    synchronized (lock) {

      if (shutdown) {
        throw new IllegalStateException(
            "Scheduler is shutdown");
      }

      if (jobs.containsKey(job.getId())) {
        throw new IllegalArgumentException(
            "Job already exists");
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

      if (job == null ||
          job.getStatus() != JobStatus.SCHEDULED) {
        return false;
      }

      queue.remove(job);
      job.setStatus(JobStatus.CANCELLED);

      return true;
    }
  }

  // Reschedule
  public boolean reschedule(
      String jobId,
      long newExecuteAt) {

    synchronized (lock) {

      Job job = jobs.get(jobId);

      if (job == null ||
          job.getStatus() != JobStatus.SCHEDULED) {
        return false;
      }

      queue.remove(job);

      job.setExecuteAt(newExecuteAt);

      queue.offer(job);

      lock.notifyAll();

      return true;
    }
  }

  // Get status
  public JobStatus getStatus(String jobId) {

    synchronized (lock) {

      Job job = jobs.get(jobId);

      return job == null
          ? null
          : job.getStatus();
    }
  }

  // Scheduler thread
  private void processJobs() {

    while (true) {

      Job job;

      synchronized (lock) {

        while (queue.isEmpty() && !shutdown) {

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

        long delay =
            job.getExecuteAt()
                - System.currentTimeMillis();

        if (delay > 0) {

          try {
            lock.wait(delay);
          } catch (InterruptedException e) {
            return;
          }

          continue;
        }

        queue.poll();

        if (job.getStatus() ==
            JobStatus.CANCELLED) {
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

      if (job.getRetryCount() <
          job.getMaxRetries()) {

        job.incrementRetry();

        /*
         * Retry after 1 second.
         */
        job.setExecuteAt(
            System.currentTimeMillis()
                + 1000);

        job.setStatus(JobStatus.SCHEDULED);

        queue.offer(job);

        lock.notifyAll();

      } else {

        job.setStatus(JobStatus.FAILED);
      }
    }
  }

  // Graceful shutdown
  public void shutdown() {

    synchronized (lock) {

      shutdown = true;

      lock.notifyAll();
    }
  }
}