package threads;

public class Main {

  public static void main(String[] args) throws Exception {
    Singleton s = Singleton.getInstance();
    Doubleton d = Doubleton.getInstance();
    System.out.println(s + "\n" + d);
  }
}
