package threads;

public class ThreadStarvation {

  private static final Object monitor = new Object();

  public static void main(String[] args) {
    // High-priority threads
    for (int i = 0; i < 5; i++) {
      Thread high = new Thread(() -> {
        while (true) {
          synchronized (monitor) {
            System.out.println(Thread.currentThread().getName() + " acquired lock");
          }
        }
      }, "High-Priority-" + i);
      high.setPriority(Thread.MAX_PRIORITY);
      high.start();
    }

    // Low-priority thread (starved)
    Thread low = new Thread(() -> {
      while (true) {
        synchronized (monitor) {
          System.out.println("LOW PRIORITY thread acquired lock");
        }
      }
    }, "Low-Priority");
    low.setPriority(Thread.MIN_PRIORITY);
    low.start();
  }
}

