package threads;

class ThreadOperation implements Runnable {

    volatile int x, y;
    static volatile int sum = 1;
    Thread t;

    ThreadOperation(int x, int y) {
        this.x = x;
        this.y = y;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        sum = sum * (x + y);
    }

}

public class ThreadJoinUsage {
    public static void main(String[] args) throws InterruptedException {
        ThreadOperation t1 = new ThreadOperation(10, 20);
        ThreadOperation t2 = new ThreadOperation(30, 40);
        t1.t.join();
        t2.t.join();
        System.out.println(ThreadOperation.sum);
    }
}
