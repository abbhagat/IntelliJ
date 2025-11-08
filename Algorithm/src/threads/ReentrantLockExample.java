package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();                                              // Acquire the lock
        System.out.println("Accessing the shared resource...");  // Access the shared resource
        lock.unlock();                                          // Release the lock
    }
}
