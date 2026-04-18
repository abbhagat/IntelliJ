package threads;


class QQ {

  private volatile boolean flag;
  private volatile int n;

  public synchronized void put(int n) {
    try {
      while (flag) {
        wait();
      }
      this.n = n;
      flag = !flag;
      System.out.println(Thread.currentThread().getName() + "\t" + this.n);
      notify();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public synchronized void get() {
    try {
      while (!flag) {
        wait();
      }
      System.out.println(Thread.currentThread().getName() + "\t" + this.n);
      flag = !flag;
      notify();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Producer1 implements Runnable {

  private final QQ q;

  public Producer1(QQ q) {
    this.q = q;
    new Thread(this, "Producer").start();
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      this.q.put(i);
    }
  }

}

class Consumer1 implements Runnable {

  private final QQ q;

  public Consumer1(QQ q) {
    this.q = q;
    new Thread(this, "Consumer").start();
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      this.q.get();
    }
  }

}

public class ProducerConsumer {

  public static void main(String[] args) {
    QQ q = new QQ();
    new Producer1(q);
    new Consumer1(q);
  }
}
