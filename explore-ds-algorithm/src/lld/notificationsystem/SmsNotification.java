package lld.notificationsystem;

public class SmsNotification implements NotificationChannel {

  @Override
  public boolean send(Notification notification) {
    System.out.println("Sending SMS to " + notification.getUserId());
    return true;
  }
}
