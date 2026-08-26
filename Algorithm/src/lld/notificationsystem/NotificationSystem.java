package lld.notificationsystem;

public class NotificationSystem {

  public static void main(String[] args) {
    Notification notification               = new Notification("1", "abhinawb", "Email Notification");
    NotificationChannel emailChannel        = new EmailNotification();
    NotificationChannel smsChannel          = new SmsNotification();
    NotificationChannel pushChannel         = new PushNotification();
    NotificationChannel whatsAppChannel     = new WhatsAppNotification();
    NotificationService notificationService = new NotificationService(1);
    RetryHandler retryHandler               = new RetryHandler();
    try {
      notificationService.sendAsync(notification, whatsAppChannel, NotificationType.WHATSAPP);
      notificationService.sendAsync(notification, pushChannel,     NotificationType.PUSH);
      notificationService.sendAsync(notification, smsChannel,      NotificationType.SMS);
      notificationService.sendAsync(notification, emailChannel,    NotificationType.EMAIL);
    } catch (Exception e) {
      retryHandler.retry(notification, emailChannel);
    }
     notificationService.getExecutorService().shutdown();
  }
}
