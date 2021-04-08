package semaphore;

import java.util.concurrent.Semaphore;

class Q {

    private Semaphore oddSem = new Semaphore(1);
    private Semaphore evenSem = new Semaphore(0);

    public void putOdd(int num) {
        try {
            oddSem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
        evenSem.release();
    }

    public void putEven(int num) {
        try {
            evenSem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
        oddSem.release();
    }
}

class Odd implements Runnable {
    private Q q;

    Odd(Q q) {
        this.q = q;
        new Thread(this, "Odd").start();
    }

    public void run() {
        for (int i = 1; i <= 19; i += 2) {
            q.putOdd(i);
        }
    }
}

class Even implements Runnable {

    private Q q;

    Even(Q q) {
        this.q = q;
        new Thread(this, "Even").start();
    }

    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            q.putEven(i);
        }
    }
}

public class EvenOdd {
    public static void main(String[] args) {
        Q q = new Q();
        new Even(q);
        new Odd(q);
    }
}
