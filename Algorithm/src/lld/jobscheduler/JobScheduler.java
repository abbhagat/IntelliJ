package lld.jobscheduler;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {

  private final PriorityQueue<Job> queue = new PriorityQueue<>((a, b) -> Long.compare(a.executeAt(), b.executeAt()));

  private final ExecutorService executor = Executors.newFixedThreadPool(3);

  public JobScheduler() {
    Thread schedulerThread = new Thread(this::processJobs);
    schedulerThread.start();
  }

  public void schedule(Job job) {
    synchronized (queue) {
      queue.offer(job);
      queue.notify();
    }
  }

  private void processJobs() {
    while (true) {
      Job job;
      synchronized (queue) {
        while (queue.isEmpty()) {
          try {
            queue.wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
          }
        }
        job = queue.peek();
        long delay = job.executeAt() - System.currentTimeMillis();
        if (delay > 0) {
          try {
            queue.wait(delay);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
          }
          continue;
        }

        queue.poll();
      }
      execute(job);
    }
  }

  private void execute(Job job) {
    executor.submit(() -> {
      try {
        job.task().run();
      } catch (Exception e) {
        System.out.println("Job failed: " + job.id());
      }
    });
  }
}
