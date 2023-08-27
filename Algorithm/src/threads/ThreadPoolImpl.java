package threads;


import java.util.Vector;

public class ThreadPoolImpl {

    private final Vector<WorkerThread> threadPool = new Vector<>();

    public ThreadPoolImpl() {
        this(10);
    }

    public ThreadPoolImpl(int size) {
        while (threadPool.size() <= size) {
            threadPool.add(new WorkerThread());
        }
        System.out.println("Thread Pool is Full");
    }

    public WorkerThread getConnectionFromPool() {
        WorkerThread workerThread = null;
        if (!threadPool.isEmpty()) {
            workerThread = threadPool.firstElement();
            threadPool.removeElementAt(0);
        }
        return workerThread;
    }

    public void returnConnectionToPool(WorkerThread workerThread) {
        threadPool.add(workerThread);
    }

    public static void main(String[] args) {
        ThreadPoolImpl threadPoolImpl = new ThreadPoolImpl();
        WorkerThread workerThread = threadPoolImpl.getConnectionFromPool();
        threadPoolImpl.returnConnectionToPool(workerThread);
    }
}
