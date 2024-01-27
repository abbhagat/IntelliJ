package threads;

public class ThreadStarvation extends Thread{

    static int threadcount = 1;
    public void run()
    {
        System.out.println(threadcount + "st Child" +
                " Thread execution starts");
        System.out.println("Child thread execution completes");
        threadcount++;
    }
    public static void main(String[] args)
            throws InterruptedException
    {
        System.out.println("Main thread execution starts");

        // Thread priorities are set in a way that thread5
        // gets least priority.
        ThreadStarvation thread1 = new ThreadStarvation();
        thread1.setPriority(10);
        ThreadStarvation thread2 = new ThreadStarvation();
        thread2.setPriority(9);
        ThreadStarvation thread3 = new ThreadStarvation();
        thread3.setPriority(8);
        ThreadStarvation thread4 = new ThreadStarvation();
        thread4.setPriority(7);
        ThreadStarvation thread5 = new ThreadStarvation();
        thread5.setPriority(6);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Here thread5 have to wait because of the
        // other thread. But after waiting for some
        // interval, thread5 will get the chance of
        // execution. It is known as Starvation
        thread5.start();

        System.out.println("Main thread execution completes");
    }
}
