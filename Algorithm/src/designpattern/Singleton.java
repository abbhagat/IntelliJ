package designpattern;

import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private static Singleton singleton;

  private Singleton() {
    if (null != singleton) {
      throw new RuntimeException("Use getInstance()");
    }
  }

  public static Singleton getInstance() {
    if (singleton == null) {
      synchronized (Singleton.class) { // Lock is taken on Singleton.class
        if (singleton == null) {
          singleton = new Singleton();
        }
      }
    }
    return singleton;
  }

  @Serial
  protected Object readResolve() {
    return getInstance();
  }

  @Override
  public Object clone() {
    return getInstance();
  }

  public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance();
    System.out.println(singleton.hashCode() + "\t" + Singleton.getInstance().hashCode());
  }
}
