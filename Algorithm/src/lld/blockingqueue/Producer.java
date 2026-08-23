package lld.blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;

class Producer<E> implements Runnable {

  private final BlockingQueue<E> q;
  private static final AtomicInteger ai = new AtomicInteger(1);

  public Producer(BlockingQueue<E> q, String name) {
    this.q = q;
    new Thread(this, name).start();
  }

  @Override
  public void run() {
    while (true) {
      int n = ai.getAndIncrement();
      try {
        System.out.println("Put : " + n + "\t" + Thread.currentThread().getName());
        q.put((E) Integer.valueOf(n));
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
