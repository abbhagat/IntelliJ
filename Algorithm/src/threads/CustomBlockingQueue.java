package threads;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue<K extends Number> {

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

class Producer<K extends Number> implements Runnable {

    private final BlockingQueue<K> q;

    public Producer(BlockingQueue<K> q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        Integer n = 0;
        while (true) {
            try {
                System.out.println("Put : " + ++n) ;
                q.put((K) n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer<K extends Number> implements Runnable {

    private final BlockingQueue<K> q;

    public Consumer(BlockingQueue<K> q) {
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
        new Producer<>(q);
        new Consumer<>(q);
    }
}
