package threads;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {

    private final BlockingQueue<Runnable> queue;
    private final Thread[] threads;
    private volatile boolean isStopped;

    public ThreadPool(int numThreads) {
        queue     = new LinkedBlockingQueue<>();
        threads   = new Thread[numThreads];
        isStopped = false;
        for (int i = 0; i < numThreads; i++) {
             threads[i] = new Worker(queue);
             threads[i].start();
        }
    }

    public void execute(Runnable task) {
        if (isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        queue.offer(task);
    }

    public void stop() {
        isStopped = true;
        Arrays.stream(threads).forEach(Thread::interrupt);
    }

    public void waitUntilAllTasksFinished() {
        while (!queue.isEmpty()) {
            Thread.yield();
        }
    }

    private static class Worker extends Thread {

        private final BlockingQueue<Runnable> queue;

        public Worker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Runnable task = queue.take();
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
        ThreadPool threadPool = new ThreadPool(5);
        for (int i = 0; i < 10; i++) {
             final int taskNum = i;
             Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + " is executing task " + taskNum);
             threadPool.execute(runnable);
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
