package threads;

public class ThreeThreadsPrintingOneTwoThree {

    private static final Object monitor = new Object();
    private static volatile Integer count = 1;
    static boolean one = true;
    static boolean two = false;
    static boolean three = false;

    public static void main(String[] args) {
        new Printer(1);
        new Printer(2);
        new Printer(3);
    }

    private static class Printer implements Runnable {

        private int threadId;

        Printer(int threadId) {
            this.threadId = threadId;
            new Thread(this, Integer.valueOf(threadId).toString()).start();
        }

        public void run() {
            print();
        }

        private void print() {
            try {
                while (true) {
                    Thread.sleep(500);
                    synchronized (monitor) {
                        if (1 == threadId) {
                            if (!one) {
                                monitor.wait();
                            } else {
                                System.out.print(count + " ");
                                one = false;
                                two = true;
                                three = false;
                                count += 1;
                                monitor.notifyAll();
                            }
                        }
                        if (2 == threadId) {
                            if (!two) {
                                monitor.wait();
                            } else {
                                System.out.print(count + " ");
                                one = false;
                                two = false;
                                three = true;
                                count += 1;
                                monitor.notifyAll();
                            }
                        }
                        if (3 == threadId) {
                            if (!three) {
                                monitor.wait();
                            } else {
                                System.out.print(count + " ");
                                one = true;
                                two = false;
                                three = false;
                                count += 1;
                                monitor.notifyAll();
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
