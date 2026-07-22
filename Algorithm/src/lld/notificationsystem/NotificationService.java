package lld.notificationsystem;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static lld.notificationsystem.NotificationStatus.FAILED;
import static lld.notificationsystem.NotificationStatus.SENT;

public class NotificationService {

  // Because sending notifications is a slow, I/O-bound task, and you usually don’t want it to block the main thread.
  @Getter
  private final ExecutorService executorService;

  public NotificationService(int numThread) {
    this.executorService = Executors.newFixedThreadPool(numThread);
  }

  public void sendAsync(Notification notification, NotificationChannel notificationChannel) {
    Runnable notificationTask = () -> {
      boolean success = notificationChannel.send(notification);
      notification.setStatus(success ? SENT : FAILED);
    };
    executorService.submit(notificationTask);
  }
}
