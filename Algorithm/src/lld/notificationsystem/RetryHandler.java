package lld.notificationsystem;

public class RetryHandler {

  private static final int MAX_RETRIES = 5;

  public void retry(Notification notification, NotificationChannel channel) {
    for (int i = 0; i < MAX_RETRIES; i++) {
      if (channel.send(notification)) {
        notification.setStatus(NotificationStatus.SENT);
        return;
      }
    }
    notification.setStatus(NotificationStatus.FAILED);
  }
}
