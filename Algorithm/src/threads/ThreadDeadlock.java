package threads;

class Thread1 implements Runnable {

    private final ThreadDeadlock threadDeadlock;

    public Thread1(ThreadDeadlock threadDeadlock) {
        this.threadDeadlock = threadDeadlock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        threadDeadlock.method1();
        threadDeadlock.method2();
    }
}

class Thread2 implements Runnable {

    private final ThreadDeadlock threadDeadlock;

    public Thread2(ThreadDeadlock threadDeadlock) {
        this.threadDeadlock = threadDeadlock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        threadDeadlock.method2();
        threadDeadlock.method1();
    }
}
public class ThreadDeadlock {

    public void method1() {
        synchronized (Integer.class) {
            System.out.println("Lock On Integer class");
            synchronized (String.class) {
                System.out.println("Lock On String class");
            }
        }
    }

    public void method2() {
        synchronized (String.class) {
            System.out.println("Lock On String class");
            synchronized (Integer.class) {
                System.out.println("Lock On Integer class");
            }
        }
    }

    public static void main(String[] args) {
        ThreadDeadlock threadDeadlock = new ThreadDeadlock();
        new Thread1(threadDeadlock);
        new Thread2(threadDeadlock);
    }
}
