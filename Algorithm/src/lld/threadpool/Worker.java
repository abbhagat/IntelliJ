package lld.threadpool;

import java.util.concurrent.BlockingQueue;

class Worker extends Thread {

  private final BlockingQueue<Runnable> queue;

  public Worker(BlockingQueue<Runnable> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      try {
        Runnable task = queue.take();
        task.run();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
