package java8.interfaces;

@FunctionalInterface
interface Interface1 {

    static void print(String str) {
        System.out.println("Printing " + str);
    }

    void method1(String str);

    default void log(String str) {
        System.out.println("I1 logging::" + str);
    }

    /*
     * trying to override Object method gives compile time error as a default method cannot override a method
     * from java.lang.Object" Ex:- default String toString(){ return "i1"; }
     */

}

@FunctionalInterface
interface Interface2 {
    void method1(String str);

    default void log(String str) {
        System.out.println("I1 logging::" + str);
    }
}

class A implements Interface1 {
    @Override
    public void method1(String str) {
        System.out.println("method1 called for Interface1");
    }

    @Override
    public void log(String str) {
        System.out.println("log called for Interface1");
    }
}

class B implements Interface1, Interface2 {

    @Override
    public void method1(String str) {
        System.out.println("method1 called for Interface2");
    }

    public void display() {
        System.out.println();
    }

    @Override
    public void log(String str) {
        System.out.println("I1 logging::" + str);
    }

}


public class FInterfaceDemo {

    public static void main(String[] args) {
        Interface1 interface1 = new A();
        interface1.log("interface2");
        Interface1.print("static method of interface1");
        B b = new B();
        b.log("interface2");
        b.method1("method of interface2");
        interface1.method1("method of interface1");
    }
}
