package java;

@FunctionalInterface
interface I1 {

    void display();

    default void defaultMethod() {
        System.out.println("Default Method of I1");
    }

    static void staticMethod() {
        System.out.println("Static Method of I1");
    }
}

@FunctionalInterface
interface I2 {

    void display();

    default void defaultMethod() {
        System.out.println("Default Method of I2");
    }

    static void staticMethod() {
        System.out.println("Static Method of I2");
    }
}

class A implements I1, I2 {

    public void display() {
        System.out.println("A display() method called");
        I1.staticMethod();
        I2.staticMethod();
    }

    // Necessary to override as there will be ambiguity
    @Override
    public void defaultMethod() {
        I1.staticMethod();
        I2.staticMethod();
    }
}

public class FunctionalInterfaceInheritanceDemo {

    public static void main(String[] args) {
        I1 a = new A();
        a.display();
        a.defaultMethod();
        I1.staticMethod();
        I2.staticMethod();
    }
}
