package threads;

public class ThreadLocalExample {

  private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

  public static void main(String[] args) {
    Runnable task = () -> {
      int value = threadLocal.get();
      System.out.println(Thread.currentThread().getName() + ": " + value);
      threadLocal.set(value + 1);
      value = threadLocal.get();
      System.out.println(Thread.currentThread().getName() + ": " + value);
    };
    new Thread(task, "Thread-A").start();
    new Thread(task, "Thread-B").start();
  }
}
