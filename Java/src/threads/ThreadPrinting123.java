package threads;

public class ThreadPrinting123 {

    public static void main(String[] args) {
        new Printer(1);
        new Printer(2);
        new Printer(3);
    }
}

class Printer {

    private static volatile Integer threadIdToRun = 1;
    private static volatile Integer count = 1;
    private static final Object object = new Object();
    private int threadId;

    Printer(int threadId) {
        this.threadId = threadId;
        new Thread(runnable, Integer.toString(threadId)).start();
    }

    Runnable runnable = () -> {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (object) {
                    if (threadId != threadIdToRun) {
                        object.wait();
                    } else {
                        //System.out.print(threadId + " "); // 1 2 3 1 2 3 1 2 3 ...
                        System.out.println("Thread " + threadId + ": --> " + count++ + " ");  // 1 2 3 4 5 6 7 8 9 ...
                        switch (threadId) {
                            case 1:
                                threadIdToRun = 2;
                                break;
                            case 2:
                                threadIdToRun = 3;
                                break;
                            case 3:
                                threadIdToRun = 1;
                                break;
                        }
                        object.notifyAll();
                    }
                }
            } catch (InterruptedException | IllegalMonitorStateException e) {
                e.printStackTrace();
            }
        }
    };
}
