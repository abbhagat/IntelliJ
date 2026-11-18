package threads;

class OddEvenThreadPrinter implements Runnable {

  private static final Object monitor = new Object();
  private static String threadIDToRun = "ODD";
  private static int n = 1;
  private final String threadID;

  public OddEvenThreadPrinter(String threadID) {
    this.threadID = threadID;
    new Thread(this, "Thread - " + threadID).start();
  }

  @Override
  public void run() {
    while (n <= 20) {
      try {
        synchronized (monitor) {
          if (!threadID.equals(threadIDToRun)) {
            monitor.wait();
          } else {
            System.out.println(n++ + " " + Thread.currentThread().getName());
            threadIDToRun = threadID.equals("EVEN") ? "ODD" : "EVEN";
            monitor.notifyAll();
          }
        }
      } catch (InterruptedException e) {
        System.out.println("Exception occurred with " + e.getMessage());
      }
    }
  }
}

public class ThreadPrintingOddEven {

  public static void main(String[] args) {
    new OddEvenThreadPrinter("ODD");
    new OddEvenThreadPrinter("EVEN");
  }
}
