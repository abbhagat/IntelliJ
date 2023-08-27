package threads;

import java.util.concurrent.*;

public class AdditionUsingFiveThreads {

    private static class WorkerThread implements Callable<Integer> {

        private final int start, end;
        private int sum;

        public WorkerThread(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }

        @Override
        public Integer call() {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
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
            System.out.println(future.get());
            Thread.sleep(500);
        }
        service.shutdown();
    }
}
