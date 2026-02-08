package threads;

import java.util.concurrent.*;

public class AdditionUsingFiveThreads {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService service = Executors.newFixedThreadPool(5);
    WorkerThread[] workerThreads = new WorkerThread[10];
    for (int i = 0; i < 10; i++) {
      workerThreads[i] = new WorkerThread(i + 10,  i + 20);
    }
    for (WorkerThread workerThread : workerThreads) {
      Future<Integer> future = service.submit(workerThread);
      System.out.println("Return Val of call() " + future.get());  // future.get() is a synchronous call it blocks the current thread
    }
    service.shutdown();
  }

  private record WorkerThread(int start, int end) implements Callable<Integer> {

    @Override
    public Integer call() {
      int sum = 0;
      for (int i = start; i <= end; i++) {
        sum += i;
      }
      System.out.println("Sum calculated by thread : " + Thread.currentThread().getName() + "\t" + sum);
      return sum;
    }
  }
}
