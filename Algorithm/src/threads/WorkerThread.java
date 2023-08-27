package threads;

public class WorkerThread implements Runnable {

    public WorkerThread() {
        new Thread(this, "Worker Thread").start();
    }

    @Override
    public void run() {
        System.out.println("Worker Thread Execution");
    }
}
