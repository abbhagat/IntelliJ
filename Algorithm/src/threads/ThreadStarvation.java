package threads;

public class ThreadStarvation extends Thread {

    public ThreadStarvation(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread execution starts");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread execution starts");
        ThreadStarvation[] thread = new ThreadStarvation[5];
        for (int i = 0; i < thread.length; i++) {
             thread[i] = new ThreadStarvation("Thread-" + i);
             if (i == 4) {
                 thread[i].setPriority(1);       // Set the last thread to low priority
             } else {
                 thread[i].setPriority(10 - i); // Set other threads to high priority
             }
             thread[i].start();
        }
        System.out.println("Main thread execution completes");
    }
}
