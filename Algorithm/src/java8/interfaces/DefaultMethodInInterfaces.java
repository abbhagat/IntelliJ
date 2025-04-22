package java8.interfaces;

interface InterfaceA {
    default void defaultMethod() {
        System.out.println("Interface A default method");
        staticMethod();
        display();
    }

    private void display() {
        System.out.println("Interface A private method");
    }

    static void staticMethod() {
        System.out.println("Interface A static method");
    }

    void add();
}

interface InterfaceB {
    default void defaultMethod() {
        System.out.println("Interface B default method");
    }

    void add();
}

class Impl implements InterfaceA, InterfaceB {

    @Override
    public void defaultMethod() {
        InterfaceA.super.defaultMethod();
        InterfaceB.super.defaultMethod();
    }

    @Override
    public void add() {
        System.out.println("Hello");
    }
}

public class DefaultMethodInInterfaces {

    public static void main(String[] args) {
        new Impl().defaultMethod();
        InterfaceA.staticMethod();
        // new Impl().staticMethod();  compilation error
        // InterfaceA.defaultMethod(); compilation error
    }
}
