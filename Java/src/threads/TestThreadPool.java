package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {
    
    private String message;

    public WorkerThread(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        delay(); // call delay method that sleeps the thread for 2 seconds
        System.out.println(Thread.currentThread().getName() + " (End)"); // prints thread name
    }

    private void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5); // creating a pool of 5 threads
        for (int i = 0; i < 5; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker); // calling execute method of ExecutorService
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            
        }
        System.out.println("Finished all threads");
    }
}
