package threads;

import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private static volatile Singleton singleton;

  // new Singleton() -> this object lives in Heap, but it's reference singleton stays in main memory
  // and each thread may cache the reference variable locally.
  // Every read gets the latest value from main memory.
  // Every write is immediately visible to other threads.
  // Without it, threads may use cached values (CPU cache / registers), leading to stale reads.

  private Singleton() {
    if (null != singleton) {
      throw new RuntimeException("Use getInstance()");
    }
  }

  public static Singleton getInstance() {
    if (null == singleton) {
      synchronized (Singleton.class) {
        if (null == singleton) {
          singleton = new Singleton();
        }
      }
    }
    return singleton;
  }

  // To prevent from Serializable
  @Serial
  protected Object readResolve() throws Exception {
    return getInstance();
  }

  @Override
  public Singleton clone() throws CloneNotSupportedException {
    try {
      singleton = getInstance();
    } catch (Exception e) {
      throw new CloneNotSupportedException();
    }
    return singleton;
  }
}
