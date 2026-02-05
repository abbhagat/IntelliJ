package lld.notificationsystem;

class PushNotification implements NotificationChannel {

  @Override
  public boolean send(Notification notification) {
    System.out.println("Sending PUSH notification");
    return true;
  }
}
