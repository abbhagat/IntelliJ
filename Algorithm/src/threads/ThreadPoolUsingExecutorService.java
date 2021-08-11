package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}

public class ThreadPoolUsingExecutorService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            executorService.submit(new WorkerThread());
        }
        executorService.shutdown();
    }
}
