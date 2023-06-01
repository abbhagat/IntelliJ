package threads;


import java.util.Vector;

class WorkersThread implements Runnable {

    private Thread thread;
    public WorkersThread() {
        thread = new Thread(this, "");
        thread.start();
    }

    @Override
    public void run() {

    }
}

public class ThreadPoolImpl {

    private final int POOL_SIZE = 10;
    private Vector<WorkersThread> threadPool = new Vector<>();

    public ThreadPoolImpl() {
        initializeThreadPool();
    }

    private void initializeThreadPool() {
        while (!isThreadPoolFull()) {
            threadPool.add(createNewThread());
        }
        System.out.println("Thread Pool is Full");
    }

    private boolean isThreadPoolFull() {
        return threadPool.size() <= POOL_SIZE ? true : false;
    }

    private WorkersThread createNewThread() {
        return new WorkersThread();
    }

    public WorkersThread getConnectionFromPool() {
        WorkersThread thread = null;
        if (threadPool.size() > 0) {
            thread = threadPool.firstElement();
            threadPool.removeElementAt(0);
        }
        return thread;
    }

    public void returnConnectionToPool(WorkersThread thread) {
        threadPool.add(thread);
    }

    public static void main(String[] args) {

    }
}
