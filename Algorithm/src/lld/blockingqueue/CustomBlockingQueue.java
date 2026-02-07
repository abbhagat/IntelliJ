package lld.blockingqueue;

public class CustomBlockingQueue {

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<String> q = new BlockingQueue<>(5);
    new Producer<>(q);
    new Consumer<>(q);
  }
}
