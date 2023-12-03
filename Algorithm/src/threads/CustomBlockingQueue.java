package threads;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue {

    private final Queue<Integer> queue;
    private final int maxSize;

    public BlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new LinkedList<>();
    }

    public synchronized void put(int n) throws InterruptedException {
        if (queue.size() == maxSize) {
            wait();
        }
        queue.add(n);
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        if (queue.isEmpty()) {
            wait();
        }
        notifyAll();
        return queue.remove();
    }
}

class Producer implements Runnable {

    private final BlockingQueue q;

    public Producer(BlockingQueue q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int n = 1;
        while (true) {
            try {
                System.out.println("Put : " + n++) ;
                q.put(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class Consumer implements Runnable {
    private final BlockingQueue q;

    public Consumer(BlockingQueue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Get : " + q.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class CustomBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue q = new BlockingQueue(5);
        new Producer(q);
        new Consumer(q);
    }
}
