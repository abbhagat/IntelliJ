package java8.interfaces;

interface I {

    default void print(String str) {
        if (!isNull(str))
            System.out.println("Inside Default Print::" + str);
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");
        return str == null || str.isEmpty();
    }
}

public class FunctionalInterfaceStaticMethodDemo implements I {

    public static void main(String[] args) {
        FunctionalInterfaceStaticMethodDemo obj = new FunctionalInterfaceStaticMethodDemo();
        obj.print("ABC");
        obj.isNull("abc");
        I.isNull("abc");
//        StaticAndDefaultMethodInterface.super.print("abc");
    }

    void isNull(String str) {
        System.out.println("Impl Null Check");
        I.super.print(str);
    }
}
