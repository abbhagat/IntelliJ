package lld.notificationsystem;

class SmsNotification implements NotificationChannel {

  @Override
  public boolean send(Notification notification) {
    System.out.println("Sending SMS to " + notification.getUserId());
    return true;
  }
}
