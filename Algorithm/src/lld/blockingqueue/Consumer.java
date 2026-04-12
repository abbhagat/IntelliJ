package lld.blockingqueue;

class Consumer<E> implements Runnable {

  private final BlockingQueue<E> q;

  public Consumer(BlockingQueue<E> q, String name) {
    this.q = q;
    new Thread(this, name).start();
  }

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("Get : " + q.get() + "\t" + Thread.currentThread().getName());
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
