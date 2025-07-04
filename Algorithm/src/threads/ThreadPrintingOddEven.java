package threads;

class OddEvenThreadPrinter {

    private static final Object monitor = new Object();
    private static volatile String threadIDToRun = "ODD";
    private static volatile int n = 1;
    private String threadID;

    public OddEvenThreadPrinter(String threadID) {
        this.threadID = threadID;
        new Thread(runnable, threadID).start();
    }

    Runnable runnable = () -> {
        while (n <= 10) {
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
    };
}

public class ThreadPrintingOddEven {

    public static void main(String[] args) {
        new OddEvenThreadPrinter("ODD");
        new OddEvenThreadPrinter("EVEN");
    }
}
