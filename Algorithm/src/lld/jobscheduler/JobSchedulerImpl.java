package lld.jobscheduler;

public class JobSchedulerImpl {

  public static void main(String[] args) throws InterruptedException {
    JobScheduler scheduler = new JobScheduler();
    // Normal job
    scheduler.schedule(new Job("job-1",() -> System.out.println("Job 1 executed"), System.currentTimeMillis() + 3000,0));
    // Job with retry
    scheduler.schedule(new Job("job-2", () -> {System.out.println("Job 2 executed"); throw new RuntimeException("Job failed");},System.currentTimeMillis() + 1000, 2));
    // Job that we will cancel
    scheduler.schedule(new Job("job-3", () -> System.out.println( "Job 3 executed"), System.currentTimeMillis() + 5000,0));
    scheduler.cancel("job-3");
    // Check status
    Thread.sleep(4000);
    System.out.println("Job 1: " + scheduler.getStatus("job-1"));
    System.out.println("Job 2: " + scheduler.getStatus("job-2"));
    System.out.println("Job 3: " + scheduler.getStatus("job-3"));
    scheduler.shutdown();
  }
}
