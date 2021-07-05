package threads;

import java.util.LinkedList;
import java.util.List;

interface BlockingQueueCustom<E> {

    void put(E item) throws InterruptedException;
    E take() throws InterruptedException;
}

class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E> {

    private List<E> queue;
    private int maxSize;

    public LinkedBlockingQueueCustom(int maxSize) {
        this.maxSize = maxSize;
        queue = new LinkedList<E>();
    }

    public synchronized void put(E item) throws InterruptedException {
        if (queue.size() == maxSize) {
            this.wait();
        }
        queue.add(item);
        this.notifyAll();
    }


    public synchronized E take() throws InterruptedException {

        if (queue.size() == 0) {
            this.wait();
        }
        this.notifyAll();
        return queue.remove(0);
    }
}

public class CustomBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueueCustom<Integer> b = new LinkedBlockingQueueCustom<Integer>(10);
        System.out.println("put(11)");
        b.put(11);
        System.out.println("put(12)");
        b.put(12);
        System.out.println("take() > " + b.take());
        System.out.println("take() > " + b.take());
    }
}
