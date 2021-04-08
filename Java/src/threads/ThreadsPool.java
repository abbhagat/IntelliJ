package threads;

import java.util.Vector;

public class ThreadsPool {

    private Vector<Thread> threadPool = new Vector<>();

    public ThreadsPool() {
        createThreadPool();
    }

    private void createThreadPool() {
        while (isThreadPoolFull()) {
            createThread();
        }
        System.out.println("Thread Pool is full");
    }

    private boolean isThreadPoolFull() {
        final int MAX_POOL_SIZE = 10;
        return threadPool.size() >= MAX_POOL_SIZE ? false : true;
    }

    private void createThread() {
        threadPool.add(new Thread());
    }

    public synchronized Thread getThreadFromPool() {
        Thread t = null;
        if (threadPool.size() >= 1) {
            t = threadPool.get(0);
            threadPool.remove(0);
        }
        return t;
    }

    public synchronized void returnThreadToPool(Thread t) {
        threadPool.add(t);
    }

    public static void main(String[] args) {
        ThreadsPool pool = new ThreadsPool();
        System.out.println(pool.threadPool);
    }
}
