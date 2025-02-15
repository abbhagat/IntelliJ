package threads;

class Q {

    private boolean flag;
    private int n = 1;

    public synchronized void printODD() {
        try {
            while (flag) {
                wait();
            }
            System.out.println(n++ + "->" + Thread.currentThread().getName());
            flag = true;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printEven() {
        try {
            while (!flag) {
                wait();
            }
            System.out.println(n++ + "->" + Thread.currentThread().getName());
            flag = false;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Even {

    private Q q;

    public Even(Q q) {
        this.q = q;
        new Thread(runnable, "Even").start();
    }

    Runnable runnable = () -> {
        for (int i = 2; i <= 10; i += 2) {
            q.printEven();
        }
    };
}

class Odd {

    private Q q;

    public Odd(Q q) {
        this.q = q;
        new Thread(runnable, "ODD").start();
    }

    Runnable runnable = () -> {
        for (int i = 1; i <= 10; i += 2) {
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
