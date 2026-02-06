package lld.notificationsystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationService {

  private final ExecutorService executor = Executors.newFixedThreadPool(5);

  public void sendAsync(Notification notification, NotificationChannel channel) {
    executor.submit(() -> {
      boolean success = channel.send(notification);
      notification.setStatus(success ? NotificationStatus.SENT : NotificationStatus.FAILED);
    });
  }
}
