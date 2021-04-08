package interfacedemo;

import java.io.IOException;

interface I1 {
    void display();
}

class A {
    void display() throws IOException {
        System.out.println("A");
    }
}

class B extends A implements I1 {
    public void display() {
        System.out.println("B");
    }
}

public class Override {
    static A c;

    public static void main(String[] args) throws IOException {
        // A c;
        System.out.println(c);
        System.out.println(c instanceof A); // compilation error c might not have been initialized if c is not an instance variable
        I1 a = new B();
        a.display();
        System.out.println(a instanceof B);
        System.out.println(a instanceof A);
        System.out.println(a instanceof I1);
        B b = (B)a;
        System.out.println(b instanceof I1);
        System.out.println(new A() instanceof I1);
        a.display();
    }
}
