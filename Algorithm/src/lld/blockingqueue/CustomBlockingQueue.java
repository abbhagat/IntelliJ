package lld.blockingqueue;

public class CustomBlockingQueue {

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<Integer> q = new BlockingQueue<>(5);
    new Producer<>(q, "Producer-1");
    new Producer<>(q, "Producer-2");
    new Producer<>(q, "Producer-3");
    new Consumer<>(q, "Consumer-1");
    new Consumer<>(q, "Consumer-2");
  }
}
