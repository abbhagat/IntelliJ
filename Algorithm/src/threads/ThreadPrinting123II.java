package threads;

class PrinterThreads implements Runnable {

  private static final Object monitor = new Object();
  private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
  private static int threadIdToRun = 1;
  private static int i = 0;
  private final int threadId;
  private final int[] a = new int[]{1, 4, 7};
  private final int[] b = new int[]{2, 5, 8};
  private final int[] c = new int[]{3, 6, 9};
  private final int n = a.length + b.length + c.length;

  public PrinterThreads(int threadId) {
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
            int j = threadLocal.get();
            switch (threadId) {
              case 1 -> {
                System.out.println(Thread.currentThread().getName() + " -> " + a[j]);
                threadIdToRun = 3;
              }
              case 2 -> {
                System.out.println(Thread.currentThread().getName() + " -> " + b[j]);
                threadIdToRun = 1;
              }
              case 3 -> {
                System.out.println(Thread.currentThread().getName() + " -> " + c[j]);
                threadIdToRun = 2;
              }
            }
            i++;
            threadLocal.set(j + 1);
            monitor.notifyAll();
          }
        }
      } catch (InterruptedException e) {
        System.out.println("Exception occurred with " + e.getMessage());
      }
    }
  }
}

public class ThreadPrinting123II {

  public static void main(String[] args) {
    new PrinterThreads(1);
    new PrinterThreads(2);
    new PrinterThreads(3);
  }
}
