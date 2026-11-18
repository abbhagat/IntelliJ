package lld.notificationsystem;

public class RetryHandler {

  private static final int MAX_RETRIES = 5;

  public void retry(Notification notification, NotificationChannel notificationChannel) {
    for (int i = 0; i < MAX_RETRIES; i++) {
      if (notificationChannel.send(notification)) {
        notification.setStatus(NotificationStatus.SENT);
        return;
      }
    }
    notification.setStatus(NotificationStatus.FAILED);
  }
}
