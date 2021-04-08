package threads;

import java.util.concurrent.atomic.AtomicInteger;

class Shared {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomThread implements Runnable {

    String name;

    AtomThread(String name) {
        this.name = name;
        new Thread(this, name).start();
    }

    public void run() {
        // System.out.println("Starting "+name);
        for (int i = 1; i <= 3; i++) {
            System.out.println("ai :" + Shared.ai.getAndIncrement());
            System.out.println(Shared.ai);
            // System.out.println(name+" got: "+Shared.ai.getAndSet(i));
        }
    }
}

public class AtomicDemo {
    public static void main(String[] args) {
        new AtomThread("A");
        new AtomThread("B");
        new AtomThread("C");
    }
}
