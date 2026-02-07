package lld.notificationsystem;

class EmailNotification implements NotificationChannel {

  @Override
  public boolean send(Notification notification) {
    System.out.println("Sending Email to " + notification.getUserId());
    return true; // simulate success
  }
}
