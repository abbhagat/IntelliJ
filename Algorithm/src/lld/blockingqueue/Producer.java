package lld.blockingqueue;

class Producer<E> implements Runnable {

  private final BlockingQueue<E> q;

  public Producer(BlockingQueue<E> q, String name) {
    this.q = q;
    new Thread(this, name).start();
  }

  @Override
  public void run() {
    int n = 1;
    while (true) {
      try {
        System.out.println("Put : " + n + "\t" + Thread.currentThread().getName());
        q.put((E) Integer.valueOf(n));
        n++;
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
