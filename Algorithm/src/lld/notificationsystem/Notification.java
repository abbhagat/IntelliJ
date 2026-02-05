package lld.notificationsystem;

class Notification {
  String id;
  String userId;
  String message;
  NotificationStatus status;

  public Notification(String id, String userId, String message) {
    this.id = id;
    this.userId = userId;
    this.message = message;
    this.status = NotificationStatus.PENDING;
  }
}
