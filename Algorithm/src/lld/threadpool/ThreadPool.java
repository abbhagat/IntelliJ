package lld.threadpool;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {

  private final BlockingQueue<Runnable> queue;
  private final Thread[] threads;
  private volatile boolean isStopped;

  public ThreadPool(int poolSize) {
    this.queue = new LinkedBlockingQueue<>();
    this.threads = new Thread[poolSize];
    this.isStopped = false;
    for (int i = 0; i < poolSize; i++) {
      this.threads[i] = new Worker(queue);
      this.threads[i].start();
    }
  }

  public void addTaskToQueue(Runnable task) {
    if (this.isStopped) {
      throw new IllegalStateException("ThreadPool is stopped");
    }
    this.queue.add(task);
  }

  public void waitUntilAllTasksFinished() {
    while (!this.queue.isEmpty()) {
      Thread.yield();   // A hint to the scheduler that the current thread is willing to yield its current use of a processor.
      // The scheduler is free to ignore this hint.
    }
  }

  public void stop() {
    this.isStopped = true;
    Arrays.stream(this.threads).forEach(Thread::interrupt);
  }

}
