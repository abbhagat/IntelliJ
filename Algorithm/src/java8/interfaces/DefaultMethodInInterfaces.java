package java8.interfaces;

interface InterfaceA {
    default void defaultMethod() {
        System.out.println("Interface A default method");
        staticMethod();
    }

    static void staticMethod() {
        System.out.println("Interface A static method");
    }
}

interface InterfaceB {
    default void defaultMethod() {
        System.out.println("Interface B default method");
    }
}

class Impl implements InterfaceA, InterfaceB {

    @Override
    public void defaultMethod() {
        InterfaceA.super.defaultMethod();
        InterfaceB.super.defaultMethod();
    }
}

public class DefaultMethodInInterfaces {

    public static void main(String[] args) {
        new Impl().defaultMethod();
        InterfaceA.staticMethod();
        // new Impl().staticMethod();
        // InterfaceA.defaultMethod();
    }
}
