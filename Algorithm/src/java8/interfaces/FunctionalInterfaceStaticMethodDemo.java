package java8.interfaces;

interface StaticAndDefaultMethodInterface {

    default void print(String str) {
        if (!isNull(str))
            System.out.println("Inside Default Print::" + str);
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");
        return str == null ? true : "".equals(str) ? true : false;
    }
}

public class FunctionalInterfaceStaticMethodDemo implements StaticAndDefaultMethodInterface {

    public static void main(String args[]) {
        FunctionalInterfaceStaticMethodDemo obj = new FunctionalInterfaceStaticMethodDemo();
        obj.print("");
        obj.isNull("abc");
        StaticAndDefaultMethodInterface.isNull("abc");
        //StaticAndDefaultMethodInterface.super.print("abc");
    }

    boolean isNull(String str) {
        System.out.println("Impl Null Check");
        StaticAndDefaultMethodInterface.super.print("abc");
        return str == null ? true : false;
    }
}
