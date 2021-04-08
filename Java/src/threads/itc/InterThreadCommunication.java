package threads.itc;

class Q {

    private volatile int n = 0;
    private boolean flag = false;

    synchronized void get() {
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

    synchronized void put(int n) {
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

class Producer extends Thread {
    private Q q;

    Producer(Q q) {
        super("Producer");
        this.q = q;
    }

    public void run() {
        int i = 1;
        while (true) {
            q.put(i++);
        }
    }
}

class Consumer extends Thread {

    private Q q;

    Consumer(Q q) {
        super("Consumer");
        this.q = q;
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        System.out.println("Press Ctrl +C to break");
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);
        producer.start();
        consumer.start();
    }
}
