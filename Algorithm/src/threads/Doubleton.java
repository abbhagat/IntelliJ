package threads;

import java.io.Serial;
import java.io.Serializable;

public class Doubleton implements Cloneable, Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private static Doubleton instance1, instance2;
  private static int n = 1;

  private Doubleton() {}

  public static synchronized Doubleton getInstance() {
    if (instance1 == null) {
      instance1 = new Doubleton();
      return instance1;
    }
    if (instance2 == null) {
      instance2 = new Doubleton();
      return instance2;
    }
    return n++ % 2 == 0 ? instance1 : instance2;
  }

  @Serial
  protected Object readResolve() {
    return getInstance();
  }

  @Override
  public Doubleton clone() {
    return getInstance();
  }
}
