package innerclass;

class A {
    private int x = 30;

    protected class B {
        private int x = 100;
    }

    void display() {
        B b = new B();
        System.out.println(b.x);
    }

    class C {
        private int x = 10;

        public void display() {
            System.out.println(this.x);
            System.out.println(A.this.x);
            new A().display();
        }
    }

    static class D extends A implements Cloneable {
        public static void displayD() {
            System.out.println("Static Class D display method()");
        }
    }
}

public class InnerClassDemo {

    public static void main(String[] args) {
        final int x;
        x = 100;
        A a = new A();
        A.C c = a.new C();
        c.display();
        A.B b = new A().new B();
        A.D d = new A.D();
        d.displayD();
        A.D.displayD();
    }
}
