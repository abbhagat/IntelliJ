package threads;

class K1 {

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

class Odds extends Thread {
    K1 q;

    Odds(K1 q) {
        this.q = q;
    }

    public void run() {
        int i, j = 1;
        for (i = 1; i <= 10; i++) {
            q.odd(j);
            j += 2;
        }
    }
}

class Evens extends Thread {
    K1 q;

    Evens(K1 q) {
        this.q = q;
    }

    public void run() {
        int i, j = 2;
        for (i = 1; i <= 10; i++) {
            q.even(j);
            j += 2;
        }
    }
}

public class ExtendsThread {
    public static void main(String[] args) {
        K1 q = new K1();
        new Evens(q).start();
        new Odds(q).start();
    }
}
