package threads;

public class ThreadDeadLock {

  private static final Object LOCK_1 = new Object();
  private static final Object LOCK_2 = new Object();

  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {
      synchronized (LOCK_1) {
        System.out.println("Thread 1: Holding LOCK_1");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (LOCK_2) {
          System.out.println("Thread 1: Holding LOCK_2");
        }
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (LOCK_2) {
        System.out.println("Thread 2: Holding LOCK_2");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (LOCK_1) {
          System.out.println("Thread 2: Holding LOCK_1");
        }
      }
    });

    t1.start();
    t2.start();
  }
}

