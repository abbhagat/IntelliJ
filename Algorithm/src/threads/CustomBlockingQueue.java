package threads;

import java.util.LinkedList;
import java.util.Queue;

// peek() retrieves head of the queue element and returns null if the queue is empty
// remove() throws an exception if the queue is empty whereas poll() returns null is the queue is empty
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
        int n = 0;
        while (true) {
            try {
                System.out.println("Put : " + ++n) ;
                q.put((K)Integer.valueOf(n));
                Thread.sleep(1000);
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
                Thread.sleep(100);
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
