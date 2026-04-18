package threads;

import java.util.concurrent.*;

public class ThreadPoolUsingExecutorService {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 1; i <= 5; i++) {
      Future<?> future = executorService.submit(new WorkerThread(i, "Message " + i));
      System.out.println(future.get());
    }
    executorService.shutdown();
  }

  private record WorkerThread(int threadId, String message) implements Runnable {

    public WorkerThread(int threadId, String message) {
      this.threadId = threadId;
      this.message = message;
      new Thread(this, "Thread " + threadId).start();
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " " + this.message);
    }
  }

/*  private record WorkerThread(int n) implements Callable<String> {

    private static String message;

    @Override
    public String call() {
      System.out.println(Thread.currentThread().getName());
      return "Worker Thread Execution";
    }
  }*/
}
