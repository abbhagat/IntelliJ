package enums;

// short -> int -> long -> float -> double -> Short -> Number -> Object

public class MethodOverloadingExample {

    private static void display(Object obj) {
        System.out.println("Object");
    }

    private static void display(Number obj) {
        System.out.println("Number");
    }

    private static void display(Short sort) {
        System.out.println("Short");
    }

    private static void display(Integer integer) {
        System.out.println("Integer");
    }

    private static void display(byte b) {
        System.out.println("byte");
    }

    private static void display(int i) {
        System.out.println("int");
    }

    private static void display(long l) {
        System.out.println("long");
    }

    private static void display(float f) {
        System.out.println("float");
    }

    private static void display(double d) {
        System.out.println("double");
    }

    public static void main(String[] args) {
        short x = 1;
        display(x);
    }
}
