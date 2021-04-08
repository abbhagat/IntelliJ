package threads;

class Q {

    private volatile boolean flag;
    private volatile int n = 1;

    public synchronized void printODD() {
        try {
            Thread.sleep(500);
            while (flag) {
                wait();
            }
            System.out.println(n++ + " " + Thread.currentThread().getName());
            flag = true;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printEven() {
        try {
            Thread.sleep(500);
            while (!flag) {
                wait();
            }
            System.out.println(n++ + " " + Thread.currentThread().getName());
            flag = false;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Even {

    private Q q;

    Even(Q q) {
        this.q = q;
        new Thread(runnable, "Even").start();
    }

    Runnable runnable = () -> {
        while (true) {
            q.printEven();
        }
    };
}

class Odd {

    private Q q;

    Odd(Q q) {
        this.q = q;
        new Thread(runnable, "ODD").start();
    }

    Runnable runnable = () -> {
        while (true) {
            q.printODD();
        }
    };
}


public class OddEven {

    public static void main(String[] args) {
        Q q = new Q();
        new Odd(q);
        new Even(q);
    }
}
