package threads;

import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Doubleton implements Cloneable, Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private static Doubleton instance1, instance2;
  private static volatile int index;

  private Doubleton() {
    if (instance1 != null && instance2 != null) {
      throw new RuntimeException("Can't instantiate doubleton twice");
    }
  }

  public static synchronized Doubleton getInstance() {
    instance1 = (null == instance1) ? new Doubleton() : instance1;
    instance2 = (null == instance2) ? new Doubleton() : instance2;
    return index++ % 2 == 0 ? instance1 : instance2;
  }

  @Serial
  public Object readResolve() {
    return getInstance();
  }

  @Override
  public Object clone() {
    return getInstance();
  }

  public static void main(String[] args) {
    designpattern.Doubleton obj1 = designpattern.Doubleton.getInstance();
    designpattern.Doubleton obj2 = designpattern.Doubleton.getInstance();
    designpattern.Doubleton obj3 = designpattern.Doubleton.getInstance();
    designpattern.Doubleton obj4 = designpattern.Doubleton.getInstance();
    designpattern.Doubleton obj5 = designpattern.Doubleton.getInstance();
    designpattern.Doubleton obj6 = designpattern.Doubleton.getInstance();
    System.out.println("Printing the hashcode to check memory addresses");
    System.out.println("obj1.hashCode() : " + obj1.hashCode());
    System.out.println("obj3.hashCode() : " + obj3.hashCode());
    System.out.println("obj5.hashCode() : " + obj5.hashCode());
    System.out.println("obj2.hashCode() : " + obj2.hashCode());
    System.out.println("obj4.hashCode() : " + obj4.hashCode());
    System.out.println("obj6.hashCode() : " + obj6.hashCode());
    System.out.println("Printing the Object's Attributes");
    System.out.println("obj1 : " + obj1);
    System.out.println("obj2 : " + obj2);
    System.out.println("obj3 : " + obj3);
    System.out.println("obj4 : " + obj4);
    System.out.println("obj5 : " + obj5);
    System.out.println("obj6 : " + obj6);
    System.gc();
  }
}
