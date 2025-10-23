package serialization;

import java.io.*;

/**
 * Serialization Rule
 * <p>
 * During serialization process, if any instance variable is inherited from non-serializable parent class,
 * then JVM will ignore the normal value instead it will store the default value for that variable.
 * <p>
 * Deserialization Rule
 * During deserialization process, if we have any non-serializable parent class,
 * then JVM will perform following things for that non-serializable parent class.
 * Variable Initialization will be done.
 * Instance block will be executed.
 * No-argument constructor will be executed.
 */

class Father {

  transient int parent;
  String s = "Java";

  int x = 5;

  public Father() {
    System.out.println("Father Constructor");
    parent = 3;
    s = "Java is an OOP";
  }

  {
    System.out.println("Non static Father Block");
    parent = 2;
    s = "Java is OOP";
  }
}

class Son extends Father implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  transient int k = 4;
  static int y = 100;
  int child = 4;

  public Son() {
    System.out.println("Son Constructor");
    child = 10;
    k = 100;
  }

  {
    System.out.println("Non static Son Block");
    child = 1000;
    k = 1000;
  }

}

public class SerializableDemo {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Son son = new Son();
    son.x = 50;
    son.parent = 500;
    Son.y = 500;
    FileOutputStream fileOutputStream = new FileOutputStream("son.txt");
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(son);
    FileInputStream fileInputStream = new FileInputStream("son.txt");
    ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
    son = (Son) inputStream.readObject();
    System.out.println(son.parent + " " + son.s + " " + son.x);
    System.out.println(son.child);
    System.out.println(son.k);
    System.out.println(Son.y);
  }
}
