package lld.jobscheduler;

public class JobSchedulerImpl {

  public static void main(String[] args) throws InterruptedException {
    JobScheduler scheduler = new JobScheduler(3);
    Job job1 = new Job("job-1", () -> System.out.println("Job 1 executed"), System.currentTimeMillis() + 3000, 0);
    Job job2 = new Job("job-2", () -> System.out.println("Job 2 executed"), System.currentTimeMillis() + 1000, 0);
    Job job3 = new Job("job-3", () -> System.out.println("Job 3 executed"), System.currentTimeMillis() + 2000, 0);

    scheduler.schedule(job1);
    scheduler.schedule(job2);
    scheduler.schedule(job3);

    // 2. Cancellation
    Job job4 = new Job("job-4", () -> System.out.println("Job 4 executed"), System.currentTimeMillis() + 5000, 0);
    scheduler.schedule(job4);
    boolean cancelled = scheduler.cancel("job-4");
    System.out.println("Job 4 cancelled: " + cancelled);

    // Reschedule
    Job job5 = new Job("job-5", () -> System.out.println("Job 5 executed"), System.currentTimeMillis() + 10000, 0);
    scheduler.schedule(job5);
    boolean rescheduled = scheduler.reschedule("job-5", System.currentTimeMillis() + 1500);
    System.out.println("Job 5 rescheduled: " + rescheduled);

    // Retry
    Job retryJob = new Job("retry-job", new Runnable() {
      private int attempts = 0;

      @Override
      public void run() {
        attempts++;
        System.out.println("Retry job attempt: " + attempts);
        if (attempts < 3) {
          throw new RuntimeException("Something went wrong");
        }
        System.out.println("Retry job succeeded");
      }
    },
        System.currentTimeMillis() + 1000,
        3
    );
    scheduler.schedule(retryJob);

    // Check status
    Thread.sleep(2000);
    System.out.println("Job 1 status: " + scheduler.getStatus("job-1"));
    System.out.println("Job 4 status: " + scheduler.getStatus("job-4"));
    System.out.println("Retry job status: " + scheduler.getStatus("retry-job"));

    Thread.sleep(8000);  // Give jobs enough time to finish.

    // Final status
    System.out.println("Job 1 final status: " + scheduler.getStatus("job-1"));
    System.out.println("Job 2 final status: " + scheduler.getStatus("job-2"));
    System.out.println("Job 3 final status: " + scheduler.getStatus("job-3"));
    System.out.println("Job 5 final status: " + scheduler.getStatus("job-5"));
    System.out.println("Retry job final status: " + scheduler.getStatus("retry-job"));

    // Graceful shutdown
    scheduler.shutdown();
    System.out.println("Scheduler shutdown initiated");
  }
}