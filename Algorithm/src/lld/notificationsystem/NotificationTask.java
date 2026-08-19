package lld.notificationsystem;

import static lld.notificationsystem.NotificationStatus.FAILED;
import static lld.notificationsystem.NotificationStatus.SENT;

public class NotificationTask implements Runnable, Comparable<NotificationTask> {

  private final Notification notification;
  private final NotificationChannel notificationChannel;
  private final int priority;

  public NotificationTask(Notification notification, NotificationChannel notificationChannel, int priority) {
    this.notification = notification;
    this.notificationChannel = notificationChannel;
    this.priority = priority;
  }

  @Override
  public void run() {
    boolean success = notificationChannel.send(notification);
    notification.setStatus(success ? SENT : FAILED);
  }

  @Override
  public int compareTo(NotificationTask notificationTask) {
    return Integer.compare(this.priority, notificationTask.priority);
  }
}
