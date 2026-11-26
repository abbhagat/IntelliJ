package lld.jobscheduler;

public class JobSchedulerImpl {

  public static void main(String[] args) throws InterruptedException {
    Job job       = new Job("job-1", () ->   System.out.println("Executing Job 1"), System.currentTimeMillis() + 3000,0);
    Job retryJob  = new Job("job-2", () -> {
      System.out.println("Executing Job 2");
      throw new RuntimeException("Job failed");
      },System.currentTimeMillis() + 1000, 2);
    Job cancelJob = new Job("job-3", () ->   System.out.println( "Executing Job 3"), System.currentTimeMillis() + 5000,0);

    JobScheduler jobScheduler = new JobScheduler();

    jobScheduler.schedule(job);
    jobScheduler.schedule(retryJob);
    jobScheduler.schedule(cancelJob);

    jobScheduler.cancel("job-3");
    jobScheduler.reschedule(cancelJob.getId(), System.currentTimeMillis());
    Thread.sleep(5000);

    System.out.println("Job 1: " + jobScheduler.getStatus("job-1"));
    System.out.println("Job 2: " + jobScheduler.getStatus("job-2"));
    System.out.println("Job 3: " + jobScheduler.getStatus("job-3"));

    jobScheduler.shutdown();
  }
}
