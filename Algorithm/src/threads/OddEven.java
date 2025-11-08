package threads;

class Q {

    private volatile boolean flag;
    private volatile int n = 1;

    public synchronized void printODD() {
        try {
            while (flag) {
                wait();
            }
            System.out.println(n++ + " -> " + Thread.currentThread().getName());
            flag = !flag;
            notify();
        } catch (InterruptedException e) {
            System.out.println("Exception occurred with " + e.getMessage());
        }
    }

    public synchronized void printEven() {
        try {
            while (!flag) {
                wait();
            }
            System.out.println(n++ + " -> " + Thread.currentThread().getName());
            flag = !flag;
            notify();
        } catch (InterruptedException e) {
            System.out.println("Exception occurred with " + e.getMessage());
        }
    }
}

class Even {

    private Q q;
    Runnable runnable = () -> {
        for (int i = 1; i <= 5; i++) {
            q.printEven();
        }
    };

    public Even(Q q) {
        this.q = q;
        new Thread(runnable, "Even").start();
    }
}

class Odd {

    private Q q;
    Runnable runnable = () -> {
        for (int i = 1; i <= 5; i++) {
            q.printODD();
        }
    };

    public Odd(Q q) {
        this.q = q;
        new Thread(runnable, "ODD").start();
    }
}

public class OddEven {

    public static void main(String[] args) {
        Q q = new Q();
        new Odd(q);
        new Even(q);
    }
}
