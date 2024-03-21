package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ThreadPool<Runnable> {
    private final BlockingQueue<Runnable> taskQueue;
    private final List<ThreadPoolRunnable> runnableList = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int numOfThreads, int maxNumOfTasks) {
        taskQueue = new ArrayBlockingQueue<>(maxNumOfTasks);
        for (int i = 1; i <= numOfThreads; i++) {
            ThreadPoolRunnable threadPoolRunnable = new ThreadPoolRunnable((BlockingQueue<java.lang.Runnable>) taskQueue);
            runnableList.add(threadPoolRunnable);
        }
        for (ThreadPoolRunnable runnable : runnableList) {
             new Thread(runnable).start();
        }
    }

    public synchronized void execute(Runnable task) {
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        this.taskQueue.offer(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (ThreadPoolRunnable runnable : runnableList) {
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while (!this.taskQueue.isEmpty()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadPoolRunnable implements Runnable {
    private Thread thread = null;
    private final BlockingQueue<Runnable> taskQueue;
    private boolean isStopped = false;

    public ThreadPoolRunnable(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        this.thread = Thread.currentThread();
        while (!isStopped()) {
            try {
                Runnable runnable = taskQueue.take();
                runnable.run();
            } catch (Exception e) {
                //log or otherwise report exception,but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.thread.interrupt();   //break pool thread out of dequeue() call
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}

public class ThreadPoolImpl {

    public static void main(String[] args) throws Exception {
        ThreadPool<Runnable> threadPool = new ThreadPool<>(3, 10);
        for (int i = 0; i < 10; i++) {
            int taskNum = i;
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + ": Task " + taskNum));
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
