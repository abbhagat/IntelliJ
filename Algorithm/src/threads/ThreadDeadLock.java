package threads;

public class ThreadDeadLock {

  private static final Object LOCK_1 = new Object();
  private static final Object LOCK_2 = new Object();

  private void sleep() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void simulateDeadlock() {

    Runnable r1 = () -> {
      synchronized (LOCK_1) {
        System.out.println("Thread 1: Holding LOCK_1");
        sleep();
        synchronized (LOCK_2) {
          System.out.println("Thread 1: Holding LOCK_2");
        }
      }
    };

    Runnable r2 = () -> {
      synchronized (LOCK_2) {
        System.out.println("Thread 2: Holding LOCK_2");
        sleep();
        synchronized (LOCK_1) {
          System.out.println("Thread 2: Holding LOCK_1");
        }
      }
    };

    Thread t1 = new Thread(r1, "Thread-1");
    Thread t2 = new Thread(r2, "Thread-2");

    t1.start();
    t2.start();
  }

  public static void main(String[] args) {
    new ThreadDeadLock().simulateDeadlock();
  }
}
