package threads;

class PrinterThread implements Runnable {

    private static final Object monitor = new Object();
    private static volatile int threadIdToRun = 1, n = 1;
    private final int threadId;

    PrinterThread(int threadId) {
        this.threadId = threadId;
        new Thread(this, "Thread-" + threadId).start();
    }

    @Override
    public void run() {
        while (n <= 15) {
            try {
                synchronized (monitor) {
                    if (threadId != threadIdToRun) {
                        monitor.wait();
                    } else {
                        System.out.println(threadId + " " + Thread.currentThread().getName());
                        n++;
                        switch (threadId) {
                            case 1: threadIdToRun = 2; break;
                            case 2: threadIdToRun = 3; break;
                            case 3: threadIdToRun = 1; break;
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

public class ThreadPrinting123 {

    public static void main(String[] args) {
        new PrinterThread(1);
        new PrinterThread(2);
        new PrinterThread(3);
    }
}
