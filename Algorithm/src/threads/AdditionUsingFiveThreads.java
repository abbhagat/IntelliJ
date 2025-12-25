package threads;

import java.util.concurrent.*;

public class AdditionUsingFiveThreads {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService service = Executors.newFixedThreadPool(5);
    WorkerThread[] workerThreads = new WorkerThread[10];
    workerThreads[0] = new WorkerThread(0,  10);
    workerThreads[1] = new WorkerThread(10, 20);
    workerThreads[2] = new WorkerThread(21, 30);
    workerThreads[3] = new WorkerThread(31, 45);
    workerThreads[4] = new WorkerThread(41, 50);
    workerThreads[5] = new WorkerThread(51, 60);
    workerThreads[6] = new WorkerThread(61, 70);
    workerThreads[7] = new WorkerThread(71, 680);
    workerThreads[8] = new WorkerThread(81, 90);
    workerThreads[9] = new WorkerThread(91, 100);
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
