package threads;

import java.io.Serial;
import java.io.Serializable;

public final class Doubleton implements Serializable, Cloneable {

  private static final Doubleton INSTANCE1 = new Doubleton(0);
  private static final Doubleton INSTANCE2 = new Doubleton(1);
  private static int index;
  private final int id;

  private Doubleton(int id) {
    this.id = id;
  }

  public static synchronized Doubleton getInstance() {
    return ((index++ & 1) == 0) ? INSTANCE1 : INSTANCE2;
  }

  @Serial
  private Object readResolve() {
    return id == 0 ? INSTANCE1 : INSTANCE2;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
}
