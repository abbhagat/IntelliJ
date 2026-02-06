package lld.notificationsystem;

class EmailNotification implements NotificationChannel {

  @Override
  public boolean send(Notification notification) {
    System.out.println("Sending EMAIL to " + notification.getUserId());
    return true; // simulate success
  }
}
