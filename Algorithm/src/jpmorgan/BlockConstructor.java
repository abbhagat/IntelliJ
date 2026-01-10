package jpmorgan;

class Super {

  static {
    System.out.println("Super Static Block");
  }

  {
    System.out.println("Super Non Static Block");
  }

  Super() {
    System.out.println("Super Constructor");
  }
}

class Sub extends Super {

  static {
    System.out.println("Sub Static Block");
  }

  {
    System.out.println("Sub Non Static Block");
  }

  Sub() {
    System.out.println("Sub Constructor");
  }
}

public class BlockConstructor {

  static {
    System.out.println("BlockDemo Static Block");
    String s = "Java";
    s.concat("is an OOP");
    System.out.println(s);
  }

  {
    System.out.println("Inside the Non static block of Main class");
  }

  private BlockConstructor() {
    System.out.println("Inside the Constructor of Main class");
  }

  public static void main(String[] args) {
    BlockConstructor blockConstructor = new BlockConstructor();
    new Sub();
    new Sub();
    new Super();
  }
}
