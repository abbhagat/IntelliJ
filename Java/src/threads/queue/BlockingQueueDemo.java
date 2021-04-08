package threads.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingQueue();
        Thread producer = new Thread(new Producer(sharedQueue));
        Thread consumer = new Thread(new Consumer(sharedQueue));
        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {

    private BlockingQueue sharedQueue;

    Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        int i = 1;
        while (true) {
            try {
                System.out.println("Put :" + i);
                sharedQueue.put(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue sharedQueue;

    Consumer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Get :" + sharedQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
