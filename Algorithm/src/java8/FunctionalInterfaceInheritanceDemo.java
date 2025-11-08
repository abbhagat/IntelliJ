package java8;

@FunctionalInterface
interface I1 {

    static void staticMethod() {
        System.out.println("Static Method of I1");
    }

    void display();

    String toString();   // We can override Object class method as an abstract method and this will not be counted as an abstract method.

    default void defaultMethod() {
        System.out.println("Default Method of I1");
    }
}

@FunctionalInterface
interface I2 {

    static void staticMethod() {
        System.out.println("Static Method of I2");
    }

    void display();

    String toString();   // We can override Object class method as an abstract method and this will not be counted as an abstract method.

    default void defaultMethod() {
        System.out.println("Default Method of I2");
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
        A a1 = new A();
        a1.defaultMethod();
    }
}
