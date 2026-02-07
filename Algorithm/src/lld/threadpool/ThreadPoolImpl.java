package lld.threadpool;

public class ThreadPoolImpl {

  public static void main(String[] args) {
    ThreadPool threadPool = new ThreadPool(5);
    for (int i = 0; i < 10; i++) {
      final int task = i;
      Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + " is executing task " + task);
      threadPool.addTaskToQueue(runnable);
    }
    threadPool.waitUntilAllTasksFinished();
    threadPool.stop();
  }
}
