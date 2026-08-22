package lld.jobscheduler;

public class Job {

  private final String id;
  private final Runnable task;

  private long executeAt;
  private final int maxRetries;

  private int retryCount;
  private volatile JobStatus status;

  private volatile Throwable error;

  public Job(
      String id,
      Runnable task,
      long executeAt,
      int maxRetries) {

    if (id == null || id.isBlank()) {
      throw new IllegalArgumentException("Job id cannot be empty");
    }

    if (task == null) {
      throw new IllegalArgumentException("Task cannot be null");
    }

    if (maxRetries < 0) {
      throw new IllegalArgumentException(
          "Max retries cannot be negative");
    }

    this.id = id;
    this.task = task;
    this.executeAt = executeAt;
    this.maxRetries = maxRetries;
    this.retryCount = 0;
    this.status = JobStatus.SCHEDULED;
  }

  public String getId() {
    return id;
  }

  public Runnable getTask() {
    return task;
  }

  public synchronized long getExecuteAt() {
    return executeAt;
  }

  public synchronized void setExecuteAt(long executeAt) {
    this.executeAt = executeAt;
  }

  public int getMaxRetries() {
    return maxRetries;
  }

  public synchronized int getRetryCount() {
    return retryCount;
  }

  public synchronized void incrementRetryCount() {
    retryCount++;
  }

  public JobStatus getStatus() {
    return status;
  }

  public void setStatus(JobStatus status) {
    this.status = status;
  }

  public Throwable getError() {
    return error;
  }

  public void setError(Throwable error) {
    this.error = error;
  }

  @Override
  public String toString() {
    return "Job{" +
        "id='" + id + '\'' +
        ", executeAt=" + executeAt +
        ", maxRetries=" + maxRetries +
        ", retryCount=" + retryCount +
        ", status=" + status +
        '}';
  }
}
