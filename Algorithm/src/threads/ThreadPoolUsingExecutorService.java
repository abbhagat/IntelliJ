package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class WorkerThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}

public class ThreadPoolUsingExecutorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            Future future = executorService.submit(new WorkerThread());
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
