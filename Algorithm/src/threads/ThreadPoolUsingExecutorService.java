package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolUsingExecutorService {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 1; i <= 5; i++) {
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
}
