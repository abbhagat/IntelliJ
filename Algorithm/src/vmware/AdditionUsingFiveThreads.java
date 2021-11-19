package vmware;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {

    private int start, end;
    private volatile int sum = 0;

    public WorkerThread(int start, int end) {
        this.start = start;
        this.end   = end;
    }


    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

public class AdditionUsingFiveThreads {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        WorkerThread[] workerThreads = new WorkerThread[5];
        workerThreads[0] = new WorkerThread(1, 10);
        workerThreads[1] = new WorkerThread(1, 50);
        workerThreads[2] = new WorkerThread(5, 15);
        workerThreads[3] = new WorkerThread(10, 20);
        workerThreads[4] = new WorkerThread(15, 20);
        for (int i = 0; i < workerThreads.length; i++) {
            service.execute(workerThreads[i]);
            Thread.sleep(1000);
        }
        service.shutdown();
    }
}
