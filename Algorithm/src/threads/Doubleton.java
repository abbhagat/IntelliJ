package threads;

import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Doubleton implements Serializable, Cloneable {

  @Serial
  private static final long serialVersionUID = 1L;

  private static volatile Doubleton instance1;
  private static volatile Doubleton instance2;
  private static final AtomicInteger index = new AtomicInteger(0);
  private static boolean initialized = false;

  private Doubleton() {
    synchronized (Doubleton.class) {
      if (initialized) {
        throw new RuntimeException("Use getInstance()");
      }
      initialized = true;
    }
  }

  public static Doubleton getInstance() {
    if (instance1 == null || instance2 == null) {
      synchronized (Doubleton.class) {
        if (instance1 == null) {
          instance1 = new Doubleton();
          return instance1;
        }
        if (instance2 == null) {
          instance2 = new Doubleton();
          return instance2;
        }
      }
    }
    return (index.getAndIncrement() % 2 == 0) ? instance1 : instance2;
  }

  @Serial
  protected Object readResolve() {
    return instance1;
  }

  @Override
  public Doubleton clone() throws CloneNotSupportedException {
    try {
      return getInstance();
    } catch (Exception e) {
      throw new CloneNotSupportedException();
    }
  }
}
