package threads;

class PrinterThread implements Runnable {

  private static final Object monitor = new Object();
  private static int threadIdToRun = 1;
  private static int n = 1;
  private final int threadId;

  public PrinterThread(int threadId) {
    this.threadId = threadId;
    Thread thread = new Thread(this, "Thread-" + threadId);
    thread.start();
  }

  @Override
  public void run() {
    while (n <= 15) {
      try {
        synchronized (monitor) {  // Lock is taken on java.lang.Object class
          if (threadId != threadIdToRun) {
            monitor.wait();
          } else {
            System.out.println(Thread.currentThread().getName() + " -> " + n++);
            switch (threadId) {
              case 1 -> threadIdToRun = 2;
              case 2 -> threadIdToRun = 3;
              case 3 -> threadIdToRun = 1;
            }
            monitor.notifyAll();
          }
        }
      } catch (InterruptedException e) {
        System.out.println("Exception occurred with " + e.getMessage());
      }
    }
  }
}

public class ThreadPrinting123 {

  public static void main(String[] args) {
    new PrinterThread(1);
    new PrinterThread(2);
    new PrinterThread(3);
  }
}
