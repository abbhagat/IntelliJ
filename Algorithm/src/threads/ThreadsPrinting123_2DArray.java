package threads;

class PrintThread implements Runnable {

  private static final Object monitor = new Object();
  private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
  private static int threadIdToRun = 1;
  private static int i = 0;
  private final int threadId;
  private final int[][] a = new int[][]{{1, 4, 7},
                                        {2, 5, 8},
                                        {3, 6, 9}
                                       };

  public PrintThread(int threadId) {
    this.threadId = threadId;
    new Thread(this, "Thread - " + threadId).start();
  }

  @Override
  public void run() {
    while (i < a.length * a[0].length) {
      try {
        synchronized (monitor) {
          if (threadId != threadIdToRun) {
            monitor.wait();
          } else {
            switch (threadId) {
              case 1 -> {
                System.out.println(Thread.currentThread().getName() + " -> " + a[0][threadLocal.get()]);
                threadIdToRun = 3;
              }
              case 2 -> {
                System.out.println(Thread.currentThread().getName() + " -> " + a[1][threadLocal.get()]);
                threadIdToRun = 1;
              }
              case 3 -> {
                System.out.println(Thread.currentThread().getName() + " -> " + a[2][threadLocal.get()]);
                threadIdToRun = 2;
              }
            }
            i++;
            threadLocal.set(threadLocal.get() + 1);
            monitor.notifyAll();
          }
        }
      } catch (InterruptedException e) {
        System.out.println("Exception occurred with " + e.getMessage());
      }
    }
  }
}

public class ThreadsPrinting123_2DArray {

  public static void main(String[] args) {
    new PrintThread(1);
    new PrintThread(2);
    new PrintThread(3);
  }
}
