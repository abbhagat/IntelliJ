package threads;

class PrinterThreadForNaturalNumber implements Runnable {

    private static final Object monitor = new Object();
    private static volatile int threadIdToRun = 1;
    private static volatile int n = 1;
    private final int threadID;

    public PrinterThreadForNaturalNumber(int threadID) {
        this.threadID = threadID;
        new Thread(this, "Thread-" + threadID).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                synchronized (monitor) {
                    if (threadID != threadIdToRun) {
                        monitor.wait();
                    } else {
                        System.out.print(n++ + " ");
                        switch (threadIdToRun) {
                            case 1: threadIdToRun = 2; break;
                            case 2: threadIdToRun = 3; break;
                            case 3: threadIdToRun = 4; break;
                        }
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreeThreadPrintingNaturalNumberSequence {

    public static void main(String[] args) {
        new PrinterThreadForNaturalNumber(1);
        new PrinterThreadForNaturalNumber(2);
        new PrinterThreadForNaturalNumber(3);
    }
}
