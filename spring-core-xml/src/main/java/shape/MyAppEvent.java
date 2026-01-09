package shape;

import org.springframework.context.ApplicationEvent;

public class MyAppEvent extends ApplicationEvent {
  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  public MyAppEvent(Object source) {
    super(source);
  }
}
