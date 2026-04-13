package lld.notificationsystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static lld.notificationsystem.NotificationStatus.FAILED;
import static lld.notificationsystem.NotificationStatus.SENT;

public class NotificationService {

  // Because sending notifications is a slow, I/O-bound task, and you usually don’t want it to block the main thread.
  private final ExecutorService executor = Executors.newFixedThreadPool(5);

  public void sendAsync(Notification notification, NotificationChannel channel) {
    Runnable notificationTask = () -> {
      boolean success = channel.send(notification);
      notification.setStatus(success ? SENT : FAILED);
    };
    executor.submit(notificationTask);
    executor.shutdown();
  }
}
