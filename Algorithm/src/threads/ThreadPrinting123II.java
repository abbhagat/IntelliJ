package threads;

class PrinterThreads implements Runnable {

    private static final Object monitor = new Object();

    private static int threadIdToRun = 1, n = 0;

    private final int threadId;

    private final int[] a = new int[]{1, 4, 7};
    private final int[] b = new int[]{2, 5, 8};
    private final int[] c = new int[]{3, 6, 9};

    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

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
                                System.out.println(Thread.currentThread().getName() + " " + a[threadLocal.get()]);
                                threadIdToRun = 3;
                                break;
                            case 2:
                                System.out.println(Thread.currentThread().getName() + " " + b[threadLocal.get()]);
                                threadIdToRun = 1;
                                break;
                            case 3:
                                System.out.println(Thread.currentThread().getName() + " " + c[threadLocal.get()]);
                                threadIdToRun = 2;
                                break;
                        }
                        n++;
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

public class ThreadPrinting123II {

    public static void main(String[] args) {
        new PrinterThreads(1);
        new PrinterThreads(2);
        new PrinterThreads(3);
    }
}
