package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrant Lock is a synchronization mechanism that allows the same thread to acquire the same lock multiple times.
 * It is called reentrant because the same thread can re-renter a locked section it already owns.
 */

public class ReentrantLockExample {

  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    lock.lock();                                              // Acquire the lock
    System.out.println("Accessing the shared resource...");  // Access the shared resource
    lock.unlock();                                          // Release the lock
  }
}
