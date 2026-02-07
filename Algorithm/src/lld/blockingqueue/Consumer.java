package lld.blockingqueue;

class Consumer<E> implements Runnable {

  private final BlockingQueue<E> q;

  public Consumer(BlockingQueue<E> q) {
    this.q = q;
    new Thread(this, "Consumer").start();
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      try {
        System.out.println("Get : " + q.get());
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
