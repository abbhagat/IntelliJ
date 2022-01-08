package threads.countdownlatch;

/**
 * A synchronization aid that allows one or more threads to wait until
 * a set of operations being performed in other threads completes.
 * A CountDownLatch is initialized with a given count. The await methods
 * block until the current count reaches zero due to invocations of
 * the countDown() method, after which all waiting threads are released
 * and any subsequent invocations of await return immediately.
 * This is a one-shot phenomenon the count cannot be reset.
 * If you need a version that resets the count, consider using a CyclicBarrier.
 */

import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable {

    private CountDownLatch latch;

    MyThread(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        new MyThread(latch);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CountDownLatch released");
    }
}
