

class Q {

  private volatile boolean flag;
  private volatile int n = 1;

  public synchronized void printODD() {
    while (flag) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName() + ": " + n++);
    flag = !flag;
    notify();
  }

  public synchronized void printEVEN() {
    while (!flag) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName() + ": " + n++);
    flag = !flag;
    notify();
  }

}

class ODD implements Runnable {

  private Q q;

  public ODD(Q q) {
    this.q = q;
    new Thread(this, "Odd").start();
  }

  @Override
  public void run() {
    for (int i = 1; i <= 19; i += 2) {
      q.printODD();
    }
  }
}

class EVEN implements Runnable {

  private Q q;

  public EVEN(Q q) {
    this.q = q;
    new Thread(this, "Even").start();
  }

  @Override
  public void run() {
    for (int i = 2; i <= 20; i += 2) {
      q.printEVEN();
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Q q = new Q();
    ODD odd = new ODD(q);
    EVEN even = new EVEN(q);

  }
}
