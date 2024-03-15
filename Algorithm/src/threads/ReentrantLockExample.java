package threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();                                              // Acquire the lock
        System.out.println("Accessing the shared resource...");  // Access the shared resource
        lock.unlock();                                          // Release the lock
    }
}
