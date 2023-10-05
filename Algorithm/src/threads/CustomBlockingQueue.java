package threads;

import java.util.LinkedList;
import java.util.Queue;

interface BlockingQueue<E> {

    void put(E e) throws InterruptedException;

    E get() throws InterruptedException;
}

class LinkedBlockingQueue<E> implements BlockingQueue<E> {

    private final Queue<E> queue;
    private final int maxSize;

    public LinkedBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new LinkedList<>();
    }

    public synchronized void put(E e) throws InterruptedException {
        if (queue.size() == maxSize) {
            this.wait();
        }
        queue.add(e);
        this.notifyAll();
    }

    public synchronized E get() throws InterruptedException {
        if (queue.isEmpty()) {
            this.wait();
        }
        this.notifyAll();
        return queue.poll();
    }
}

public class CustomBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        System.out.println("Put -> 11");
        blockingQueue.put(11);
        System.out.println("Put -> 12");
        blockingQueue.put(12);
        System.out.println("Get -> " + blockingQueue.get());
        System.out.println("Get -> " + blockingQueue.get());
    }
}
