package vmware;


import java.util.concurrent.*;

class WorkerThread implements Callable<Integer> {

    private int start, end;
    private volatile int sum = 0;

    public WorkerThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}

public class AdditionUsingFiveThreads {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        WorkerThread[] workerThreads = new WorkerThread[5];
        workerThreads[0] = new WorkerThread(1, 10);
        workerThreads[1] = new WorkerThread(1, 50);
        workerThreads[2] = new WorkerThread(5, 15);
        workerThreads[3] = new WorkerThread(10, 20);
        workerThreads[4] = new WorkerThread(15, 20);
        for (int i = 0; i < workerThreads.length; i++) {
            Future<Integer> future = service.submit(workerThreads[i]);
            System.out.println(future.get());
            Thread.sleep(1000);
        }
        service.shutdown();
    }
}
