package threads;

import java.util.LinkedList;
import java.util.Queue;

// peek() retrieves head of the queue element and returns null if the queue is empty
// remove() throws an exception if the queue is empty whereas poll() returns null is the queue is empty
class BlockingQueue<K extends String> {

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
    K k = q.poll();
    notifyAll();
    return k;
  }
}

class Producer<K extends String> implements Runnable {

  private final BlockingQueue<K> q;

  public Producer(BlockingQueue<K> q) {
    this.q = q;
    new Thread(this, "Producer").start();
  }

  @Override
  public void run() {
    for(int i = 1; i <= 10; i++) {
      try {
        System.out.println("Put : Message " + i);
        q.put((K) ("Message " + i));
        Thread.sleep(10);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

class Consumer<K extends String> implements Runnable {

  private final BlockingQueue<K> q;

  public Consumer(BlockingQueue<K> q) {
    this.q = q;
    new Thread(this, "Consumer").start();
  }

  @Override
  public void run() {
    for(int i = 1; i <= 10; i++) {
      try {
        System.out.println("Get : " + q.get());
        Thread.sleep(10);
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
