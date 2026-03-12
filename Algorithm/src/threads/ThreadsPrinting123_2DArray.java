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
  private final int n = a.length * a[0].length;

  public PrintThread(int threadId) {
    this.threadId = threadId;
    new Thread(this, "Thread - " + threadId).start();
  }

  @Override
  public void run() {
    while (i < n) {
      try {
        synchronized (monitor) {
          if (threadId != threadIdToRun) {
            monitor.wait();
          } else {
            int col = threadLocal.get();
            switch (threadId) {
              case 1 -> {
                System.out.println(Thread.currentThread().getName() + " -> " + a[0][col]);
                threadIdToRun = 3;
              }
              case 2 -> {
                System.out.println(Thread.currentThread().getName() + " -> " + a[1][col]);
                threadIdToRun = 1;
              }
              case 3 -> {
                System.out.println(Thread.currentThread().getName() + " -> " + a[2][col]);
                threadIdToRun = 2;
              }
            }
            i++;
            threadLocal.set(col + 1);
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
