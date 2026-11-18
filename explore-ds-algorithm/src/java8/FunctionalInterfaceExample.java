package java8;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface I {

  int x = 10;

  static boolean isNull(String str) {
    System.out.println("Interface Null Check");
    System.out.println(x);
    return str == null ? true : "".equals(str) ? true : false;
  }

  int getLength(String s);
}

@FunctionalInterface
interface Vehicle {
  default void print() {
    System.out.println("I am a vehicle!");
  }

  int getLength(String s);
}

class Car implements Vehicle {
  public void print() {
    System.out.println("Inside Car Vehicle method");
    Vehicle.super.print();
  }

  public int getLength(String s) {
    return 1;
  }
}

public class FunctionalInterfaceExample {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("Java ", "is ", "an ", "OOP.");
    I.isNull("ABC");
    I i = s -> s.length();
    for (String s : list) {
      System.out.print(i.getLength(s));
    }
    System.out.println();
    list.forEach(s -> System.out.print(s));
    System.out.println();
    list.forEach(System.out::print);
    System.out.println();
    Vehicle vehicle = new Car();
    vehicle.print();
  }
}
