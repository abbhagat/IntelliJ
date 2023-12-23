package threads;

class OddEvenThreadPrinter {

    private static final Object monitor = new Object();
    private static String threadIDToRun = "ODD";
    private String threadID;
    private static int n = 1;

    OddEvenThreadPrinter(String threadID) {
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
                        System.out.println(n + " " + Thread.currentThread().getName());
                        threadIDToRun = n++ % 2 == 0 ? "ODD" : "EVEN";
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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
