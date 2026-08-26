package lld.notificationsystem;

public class WhatsAppNotification implements NotificationChannel {
  @Override
  public boolean send(Notification notification) {
    System.out.println("Sending Whatsapp to " + notification.getUserId());
    return true;
  }
}
