package threads;

class K {

    private volatile boolean flag;

    public synchronized void odd(int n) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(n);
        notify();
        flag = true;
    }

    public synchronized void even(int n) {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(n);
        notify();
        flag = false;
    }
}

class Odd implements Runnable {
    K q;

    Odd(K q) {
        this.q = q;
        new Thread(this, "Odd").start();
    }

    public void run() {
        int i, j = 1;
        for (i = 1; i <= 10; i++) {
            q.odd(j);
            j += 2;
        }
    }
}

class Even implements Runnable {
    K q;

    Even(K q) {
        this.q = q;
        new Thread(this, "Even").start();
    }

    public void run() {
        int i, j = 2;
        for (i = 1; i <= 10; i++) {
            q.even(j);
            j += 2;
        }
    }
}

public class RunnableThread {
    public static void main(String[] args) {
        K q = new K();
        new Odd(q);
        new Even(q);
    }
}
