package lld.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

// peek() retrieves head of the queue element and returns null if the queue is empty
// if the queue is empty -> remove() throws an exception whereas poll() returns null
class BlockingQueue<E> {

  private final Queue<E> q;
  private final int maxSize;
  private final AtomicInteger count;

  public BlockingQueue(int maxSize) {
    this.q = new LinkedList<>();
    this.maxSize = maxSize;
    this.count = new AtomicInteger(1);
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

  public AtomicInteger getCount() {
    return count;
  }
}
