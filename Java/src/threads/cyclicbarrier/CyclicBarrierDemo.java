package threads.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyThread implements Runnable {

    private CyclicBarrier barrier;
    private String name;

    MyThread(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
        new Thread(this, name).start();
    }

    public void run() {
        System.out.println(name);
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class LastThread implements Runnable {

    public void run() {
        System.out.println("Last Thread to reach the barrier");
    }
}

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new LastThread());
        new MyThread(barrier, "A");
        new MyThread(barrier, "B");
        new MyThread(barrier, "C");
    }
}
