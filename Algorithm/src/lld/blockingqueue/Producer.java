package lld.blockingqueue;

class Producer<E> implements Runnable {

  private final BlockingQueue<E> q;

  public Producer(BlockingQueue<E> q, String name) {
    this.q = q;
    new Thread(this, name).start();
  }

  @SuppressWarnings("unchecked")
  @Override
  public void run() {
    while (true) {
      try {
        Integer n = q.getCount().getAndAdd(1);
        System.out.println("Put : " + n + "\t" + Thread.currentThread().getName());
        q.put((E) n);
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
