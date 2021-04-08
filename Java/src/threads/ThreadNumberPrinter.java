package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadNumberPrinter {

    private Object monitor = new Object();
    private AtomicInteger number = new AtomicInteger(1);

    class Printer implements Runnable {

        int threadId;
        int numOfThreads;

        public Printer(int id, int numOfThreads) {
            threadId = id;
            this.numOfThreads = numOfThreads;
        }

        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    synchronized (monitor) {
                        if (number.get() % numOfThreads != threadId) {
                            monitor.wait();
                        } else {
                            System.out.println(number.getAndIncrement());
                            monitor.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadNumberPrinter tnp = new ThreadNumberPrinter();
        new Thread(tnp.new Printer(0, 3)).start();
        new Thread(tnp.new Printer(1, 3)).start();
        new Thread(tnp.new Printer(2, 3)).start();
    }
}
