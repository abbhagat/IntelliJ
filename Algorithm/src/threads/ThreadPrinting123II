package threads;

class PrinterThreads implements Runnable {

    private static final Object monitor = new Object();

    private static int threadIdToRun = 1, n = 0, i = 0, j = 0, k = 0;

    private final int threadId;

    private final int[] a = new int[]{1, 4, 7};
    private final int[] b = new int[]{2, 5, 8};
    private final int[] c = new int[]{3, 6, 9};

    public PrinterThreads(int threadId) {
        this.threadId = threadId;
        new Thread(this, "Thread - " + threadId).start();
    }

    @Override
    public void run() {
        while (n < a.length + b.length + c.length) {
            try {
                synchronized (monitor) {
                    if (threadId != threadIdToRun) {
                        monitor.wait();
                    } else {
                        switch (threadId) {
                            case 1:
                                System.out.println(Thread.currentThread().getName() + " " + a[i++]);
                                threadIdToRun = 3;
                                break;
                            case 2:
                                System.out.println(Thread.currentThread().getName() + " " + b[j++]);
                                threadIdToRun = 1;
                                break;
                            case 3:
                                System.out.println(Thread.currentThread().getName() + " " + c[k++]);
                                threadIdToRun = 2;
                                break;
                        }
                        n++;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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
