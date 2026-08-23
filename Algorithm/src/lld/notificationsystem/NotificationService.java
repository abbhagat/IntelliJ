package lld.notificationsystem;

import lombok.Getter;

import java.util.concurrent.*;

public class NotificationService {

  // Because sending notifications is a slow, I/O-bound task, and you usually don’t want it to block the main thread.
  @Getter
  private final ExecutorService executorService;

  public NotificationService(int numThreads) {
     this.executorService = new ThreadPoolExecutor(numThreads, numThreads, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>()); // min heap
  }

  public void sendAsync(Notification notification, NotificationChannel notificationChannel, NotificationType channelType) {
    NotificationTask notificationTask = new NotificationTask(notification, notificationChannel, channelType.getPriority());
    executorService.submit(notificationTask);
  }
}
