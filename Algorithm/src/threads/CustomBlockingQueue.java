package threads;

import java.util.LinkedList;
import java.util.Queue;

// peek() retrieves head of the queue element and returns null if the queue is empty
// remove() throws an exception if the queue is empty whereas poll() returns null is the queue is empty
class BlockingQueue<E> {

  private final Queue<E> q;
  private final int maxSize;

  public BlockingQueue(int maxSize) {
    this.q = new LinkedList<>();
    this.maxSize = maxSize;
  }

  public synchronized void put(E e) throws InterruptedException {
    while (q.size() == maxSize) {
      wait();
    }
    q.add(e);
    notifyAll();
  }

  public synchronized E get() throws InterruptedException {
    while (q.isEmpty()) {
      wait();
    }
    E e = q.poll();
    notifyAll();
    return e;
  }
}

class Producer<E> implements Runnable {

  private final BlockingQueue<E> q;

  public Producer(BlockingQueue<E> q) {
    this.q = q;
    new Thread(this, "Producer").start();
  }

  @Override
  public void run() {
    for(int i = 1; i <= 10; i++) {
      try {
        String message = "Put : Message " + i;
        System.out.println(message);
        q.put((E) message);
         Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

class Consumer<E extends String> implements Runnable {

  private final BlockingQueue<E> q;

  public Consumer(BlockingQueue<E> q) {
    this.q = q;
    new Thread(this, "Consumer").start();
  }

  @Override
  public void run() {
    for(int i = 1; i <= 10; i++) {
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
    BlockingQueue<String> q = new BlockingQueue<>(5);
    new Producer<>(q);
    new Consumer<>(q);
  }
}
