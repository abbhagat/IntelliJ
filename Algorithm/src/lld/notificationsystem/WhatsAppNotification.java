package lld.notificationsystem;

class WhatsAppNotification implements NotificationChannel {
  @Override
  public boolean send(Notification notification) {
    return true;
  }
}
