package lld.jobscheduler;

public class Job {

  private final String id;
  private final Runnable task;
  private long executeAt;
  private final int maxRetries;
  private int retryCount;
  private JobStatus status;

  public Job(String id, Runnable task, long executeAt, int maxRetries) {
    this.id = id;
    this.task = task;
    this.executeAt = executeAt;
    this.maxRetries = maxRetries;
    this.status = JobStatus.SCHEDULED;
  }

  public String getId() {
    return id;
  }

  public Runnable getTask() {
    return task;
  }

  public long getExecuteAt() {
    return executeAt;
  }

  public void setExecuteAt(long executeAt) {
    this.executeAt = executeAt;
  }

  public int getRetryCount() {
    return retryCount;
  }

  public void incrementRetry() {
    retryCount++;
  }

  public int getMaxRetries() {
    return maxRetries;
  }

  public JobStatus getStatus() {
    return status;
  }

  public void setStatus(JobStatus status) {
    this.status = status;
  }
}
