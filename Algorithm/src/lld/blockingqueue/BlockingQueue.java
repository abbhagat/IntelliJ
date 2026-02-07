package lld.blockingqueue;

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
