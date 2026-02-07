package lld.blockingqueue;

class Producer<E> implements Runnable {

  private final BlockingQueue<E> q;

  public Producer(BlockingQueue<E> q) {
    this.q = q;
    new Thread(this, "Producer").start();
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      try {
        String message = "Message " + i;
        System.out.println("Put : " + message);
        q.put((E) message);
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
