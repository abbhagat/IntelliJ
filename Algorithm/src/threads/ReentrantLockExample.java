package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();                                              // Acquire the lock
        System.out.println("Accessing the shared resource...");  // Access the shared resource
        lock.unlock();                                          // Release the lock
    }
}
