package threads;

import java.io.Serial;
import java.io.Serializable;

public class Doubleton implements Cloneable, Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private static Doubleton instance1, instance2;
  private static int n = 1;

  private Doubleton() throws Exception {
    if (null != instance1 || null != instance2) {
      throw new Exception("Doubleton Already Initialized");
    }
  }

  @Serial
  protected Object readResolve() throws Exception {
    return getInstance();
  }

  @Override
  public Doubleton clone() throws CloneNotSupportedException {
    try {
      return getInstance();
    } catch (Exception e) {
      throw new CloneNotSupportedException();
    }
  }

  public static synchronized Doubleton getInstance() throws Exception {
    if (null == instance1) {
      instance1 = new Doubleton();
      return instance1;
    }
    if (null == instance2) {
      instance2 = new Doubleton();
      return instance2;
    }
    return n++ % 2 == 0 ? instance1 : instance2;
  }
}
