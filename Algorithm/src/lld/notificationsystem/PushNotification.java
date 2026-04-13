package lld.notificationsystem;

public class PushNotification implements NotificationChannel {

  @Override
  public boolean send(Notification notification) {
    System.out.println("Sending Push notification");
    return true;
  }
}
