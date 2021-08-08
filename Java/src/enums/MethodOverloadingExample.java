package enums;

// short -> int -> long -> float -> double -> Short -> Number -> Object

public class MethodOverloadingExample {

    static void display(Object obj) { System.out.println("Object"); }

    static void display(Number obj) { System.out.println("Number"); }

    static void display(Short sort) { System.out.println("Short");  }

    static void display(Integer integer) { System.out.println("Integer"); }

    static void display(byte b) { System.out.println("byte");  }

    static void display(int i) {System.out.println("int");}

    static void display(long l) {System.out.println("long");}

    static void display(float f) {System.out.println("float");}

    static void display(double d) {System.out.println("double");}

    public static void main(String[] args) {
        short x = 1;
        display(x);
    }
}
