package lld.notificationsystem;

public class NotificationSystem {

  public static void main(String[] args) {
    Notification notification = new Notification("1", "abhinawb", "Email Notification");
    NotificationChannel notificationChannel = new EmailNotification();
    NotificationService notificationService = new NotificationService(5);
    RetryHandler retryHandler = new RetryHandler();
    try {
      notificationService.sendAsync(notification, notificationChannel);
    } catch (Exception e) {
      retryHandler.retry(notification, notificationChannel);
    }
    notificationService.getExecutorService().shutdown();
  }
}
