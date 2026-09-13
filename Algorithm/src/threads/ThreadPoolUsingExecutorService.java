package threads;

import java.util.concurrent.*;

public class ThreadPoolUsingExecutorService {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int task = 1; task <= 10; task++) {
      executorService.submit(new WorkerThread("Message " + task));
    }
    executorService.shutdown();
  }

  private record WorkerThread(String message) implements Runnable {

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " " + this.message);
    }
  }

/*  private record WorkerThread(int n) implements Callable<String> {

    private static String message;

    @Override
    public String call() {
      System.out.println(Thread.currentThread().getName() + " " + this.message);
      return "Worker Thread Execution";
    }
  }*/
}
