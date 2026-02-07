package lld.notificationsystem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class Notification {

  private String id;
  private String userId;
  private String message;
  private NotificationStatus status;

  public Notification(String id, String userId, String message) {
    this.id = id;
    this.userId = userId;
    this.message = message;
    this.status = NotificationStatus.PENDING;
  }
}
