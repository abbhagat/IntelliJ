package threads;

class Q {

    private int n = 0;
    private volatile boolean flag;

    void get() {
        synchronized (this) {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Get :" + n);
            flag = false;
            notify();
        }
    }

    void put(int n) {
        synchronized (this) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.n = n;
            System.out.println("Put :" + n);
            flag = true;
            notify();
        }
    }
}

class Producer {
    private Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(r, "Producer").start();
    }

    Runnable r = () -> {
        int i = 1;
        while (true) {
            q.put(i++);
        }
    };
}

class Consumer {

    private Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(r, "Consumer").start();
    }

    Runnable r = () -> {
        while (true) {
            q.get();
        }
    };
}

public class ProducerConsumer {
    public static void main(String[] args) {
        System.out.println("Press Ctrl+C to break");
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
