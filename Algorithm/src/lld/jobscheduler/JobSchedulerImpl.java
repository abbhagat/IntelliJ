package lld.jobscheduler;

public class JobSchedulerImpl {

  public static void main(String[] args) {
    JobScheduler scheduler = new JobScheduler();
    scheduler.schedule(new Job("job-1", () -> System.out.println("Job 1 executed"), System.currentTimeMillis() + 3000));
    scheduler.schedule(new Job("job-2", () -> System.out.println("Job 2 executed"), System.currentTimeMillis() + 1000));
  }
}
