package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {

    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] threads;
    private volatile boolean isStopped;

    public ThreadPool(int numThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        threads = new Thread[numThreads];
        isStopped = false;
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Worker(taskQueue);
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
        if (isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        taskQueue.offer(task);
    }

    public void stop() {
        isStopped = true;
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public void waitUntilAllTasksFinished() {
        while (!taskQueue.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static class Worker extends Thread {

        private final BlockingQueue<Runnable> taskQueue;

        public Worker(BlockingQueue<Runnable> taskQueue) {
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class ThreadPoolImpl {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(4);
        for (int i = 0; i < 10; i++) {
            final int taskNum = i;
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " is executing task " + taskNum));
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
