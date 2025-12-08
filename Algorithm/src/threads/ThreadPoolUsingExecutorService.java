package threads;

import java.util.concurrent.*;

public class ThreadPoolUsingExecutorService {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 1; i <= 15; i++) {
      Future<?> future = executorService.submit(new WorkerThread());
      System.out.println(future.get());
    }
    executorService.shutdown();
  }

  private record WorkerThread() implements Runnable {

    public WorkerThread() {
      new Thread(this, "Worker Thread").start();
    }

    @Override
    public void run() {
      System.out.println("Worker Thread Execution");
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
