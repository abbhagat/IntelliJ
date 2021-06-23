package geeks;

public class ThreeThreadsPrintingOneTwoThree {

    private static Object monitor = new Object();

    private static boolean one = true;
    private static boolean two = false;
    private static boolean three = false;

    public static void main(String[] args) {

        new Thread(new SequenceDisplayImpl(1)).start();
        new Thread(new SequenceDisplayImpl(2)).start();
        new Thread(new SequenceDisplayImpl(3)).start();

    }

    static class SequenceDisplayImpl implements Runnable {

        private int threadId;

        SequenceDisplayImpl(int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            print();
        }

        private void print() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    synchronized (monitor) {
                        if (1 == threadId) {
                            if (!one) {
                                monitor.wait();
                            } else {
                                System.out.print(threadId + " ");
                                one = false;
                                two = true;
                                three = false;
                                monitor.notifyAll();
                            }
                        }
                        if (2 == threadId) {
                            if (!two) {
                                monitor.wait();
                            } else {
                                System.out.print(threadId + " ");
                                one = false;
                                two = false;
                                three = true;
                                monitor.notifyAll();
                            }
                        }
                        if (3 == threadId) {
                            if (!three) {
                                monitor.wait();
                            } else {
                                System.out.print(threadId + " ");
                                one = true;
                                two = false;
                                three = false;
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
