package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

class Main {
    ThreadLocal local;
    static AtomicInteger i;

    public static void main(String[] args) throws Exception {
        Callable c;
        System.out.println(i);
        Main m1 = new Main();
        Main m2 = new Main();
        Runnable r = new Runnable() {
            int x = 10;
            public void run() {
                display();
            }
            private synchronized void display() {
                System.out.println("x :" + x);
                x += 10;
            }
        };

        Thread t1 = new Thread(r);
        System.out.println("Thread.MAX_PRIORITY " + Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MAX_PRIORITY);
        Thread t2 = new Thread(r);
        t1.setPriority(10);
        System.out.println(t1);
        System.out.println(t2);
        t1.start();
        t2.start();
        System.out.println("Max :" + Thread.MAX_PRIORITY);
        System.out.println("Min :" + Thread.MIN_PRIORITY);
        System.out.println("Nor :" + Thread.NORM_PRIORITY);
    }
}
