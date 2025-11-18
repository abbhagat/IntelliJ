package java8.interfaces;

public class RunnableDemo {

  public static void main(String[] args) {
    Runnable r = new Runnable() {
      @Override
      public void run() {
        System.out.println("My Runnable");
      }
    };

    Runnable r1 = () -> System.out.println("My Runnable");

    Interface1 i1 = System.out::println;
    i1.method1("abc");
  }
}
