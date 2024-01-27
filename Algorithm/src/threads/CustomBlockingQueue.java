package threads;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue<K> {

    private final Queue<K> q;
    private final int maxSize;

    public BlockingQueue(int maxSize) {
        q = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void put(K k) throws InterruptedException {
        if (q.size() == maxSize) {
            wait();
        }
        q.add(k);
        notifyAll();
    }

    public synchronized K get() throws InterruptedException {
        if (q.isEmpty()) {
            wait();
        }
        notifyAll();
        return q.remove();
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
        BlockingQueue<Integer> q = new BlockingQueue<>(5);
        new Producer(q);
        new Consumer(q);
    }
}
