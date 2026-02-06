package lld.notificationsystem;

public class NotificationSystem {

  public static void main(String[] args) {
    NotificationService notificationService = new NotificationService();
    Notification notification = new Notification("1", "abhinawb", "Email Notification");
    NotificationChannel notificationChannel = new EmailNotification();
    try {
      notificationService.sendAsync(notification, notificationChannel);
    } catch (Exception e) {
      new RetryHandler().retry(notification, notificationChannel);
    }
  }
}
