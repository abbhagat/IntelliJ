package lld.notificationsystem;

class EmailNotification implements NotificationChannel {

  @Override
  public boolean send(Notification notification) {
    System.out.println("Sending EMAIL to " + notification.userId);
    return true; // simulate success
  }
}
