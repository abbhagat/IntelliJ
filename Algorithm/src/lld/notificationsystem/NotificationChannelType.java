package lld.notificationsystem;

public enum NotificationChannelType {
  EMAIL(1),
  SMS(2),
  PUSH(3),
  WHATSAPP(4);

  private final int priority;

  NotificationChannelType(int priority) {
    this.priority = priority;
  }

  public int getPriority() {
    return priority;
  }
}
