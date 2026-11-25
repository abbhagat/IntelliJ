package lld.notificationsystem;

import static lld.notificationsystem.NotificationStatus.FAILED;
import static lld.notificationsystem.NotificationStatus.SENT;

public record NotificationTask(Notification notification, NotificationChannel notificationChannel, int priority) implements Runnable, Comparable<NotificationTask> {

  @Override
  public void run() {
    boolean success = notificationChannel.send(notification);
    notification.setStatus(success ? SENT : FAILED);
  }

  @Override
  public int compareTo(NotificationTask notificationTask) {
    return Integer.compare(this.priority(), notificationTask.priority());
  }
}
