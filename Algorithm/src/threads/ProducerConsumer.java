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

  public synchronized int get() {
    try {
      while (!flag) {
        wait();
      }
      int n = this.n;
      System.out.print(Thread.currentThread().getName() + "\t");
      flag = !flag;
      notify();
      return n;
    } catch (InterruptedException e) {
      e.printStackTrace();
      return -1;
    }
  }
}

class Producer1 implements Runnable {

  private final QQ q;

  public Producer1(QQ q) {
    this.q = q;
    Thread thread = new Thread(this, "Producer");
    thread.start();
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
    Thread thread = new Thread(this, "Consumer");
    thread.start();
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      System.out.println(this.q.get());
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
