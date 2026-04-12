package lld.blockingqueue;

public class CustomBlockingQueue {

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<Integer> q = new BlockingQueue<>(5);
    new Producer<>(q, "Producer1");
    new Producer<>(q, "Producer2");
    new Producer<>(q, "Producer3");
    new Consumer<>(q, "Consumer1");
    new Consumer<>(q, "Consumer2");
  }
}
