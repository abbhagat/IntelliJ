package threads;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

class Worker extends Thread {

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

class ThreadPool {

    private final BlockingQueue<Runnable> queue;
    private final Thread[] threads;
    private volatile boolean isStopped;

    public ThreadPool(int poolSize) {
        this.queue = new LinkedBlockingQueue<>();
        this.threads = new Thread[poolSize];
        this.isStopped = false;
        IntStream.range(0, poolSize).forEach(i -> {
            this.threads[i] = new Worker(queue);
            this.threads[i].start();
        });
    }

    public void addTaskToQueue(Runnable task) {
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        this.queue.add(task);
    }

    public void waitUntilAllTasksFinished() {
        while (!this.queue.isEmpty()) {
            Thread.yield();
        }
    }

    public void stop() {
        this.isStopped = true;
        Arrays.stream(this.threads).forEach(Thread::interrupt);
    }

}

public class ThreadPoolImpl {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(5);
        IntStream.range(0, 10).forEach(task -> {
            Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + " is executing task " + task);
            threadPool.addTaskToQueue(runnable);
        });
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
