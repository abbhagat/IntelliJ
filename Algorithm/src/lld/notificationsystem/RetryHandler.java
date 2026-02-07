package lld.notificationsystem;

public class RetryHandler {

  private static final int MAX_RETRIES = 3;

  public void retry(Notification notification, NotificationChannel channel) {
    int attempts = 1;
    while (attempts <= MAX_RETRIES) {
      if (channel.send(notification)) {
        notification.setStatus(NotificationStatus.SENT);
        return;
      }
      attempts++;
    }
    notification.setStatus(NotificationStatus.FAILED);
  }
}
