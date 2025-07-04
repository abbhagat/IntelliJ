package threads;

import java.util.concurrent.*;

public class AdditionUsingFiveThreads {

    private record WorkerThread(int start, int end) implements Callable<Integer> {

        @Override
            public Integer call() {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            System.out.println("Current Thread Name : " + Thread.currentThread().getName());
                return sum;
            }
        }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        WorkerThread[] workerThreads = new WorkerThread[5];
        workerThreads[0] = new WorkerThread(10, 20);
        workerThreads[1] = new WorkerThread(21, 30);
        workerThreads[2] = new WorkerThread(31, 45);
        workerThreads[3] = new WorkerThread(41, 50);
        workerThreads[4] = new WorkerThread(51, 60);
        for (WorkerThread workerThread : workerThreads) {
            Future<Integer> future = service.submit(workerThread);
            System.out.println(future.get());  // future.get() is a synchronous call it blocks the current thread
            Thread.sleep(500);
        }
        service.shutdown();
    }
}
