package lld.jobscheduler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Job {

  private final String id;
  private final Runnable task;
  private long executeAt;
  private final int maxRetry;
  private int retryCount;
  private JobStatus status;

  public Job(String id, Runnable task, long executeAt, int maxRetry) {
    this.id         = id;
    this.task       = task;
    this.executeAt  = executeAt;
    this.maxRetry   = maxRetry;
    this.retryCount = 0;
    this.status     = JobStatus.SCHEDULED;
  }

  public void incrementRetry() {
    this.retryCount++;
  }

}
