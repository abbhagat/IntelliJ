package innerclass;

abstract class Abstract {

    static int x = 10;

    final static void display() {
        System.out.println("Static Final Method");
    }
}

class A2 {
    void disp(Integer x) {
        System.out.println("super");
    }

    void display() {
        System.out.println("Super class");
    }
}

class B2 extends A2 {
    protected void disp(Integer x) {
        System.out.println("sub");
    }

    void display1() {
        System.out.println("Super class");
    }
}

public class OverrideDemo {
    final static int x;
    final int y;

    {
        y = 100;
    }

    static {
        x = 10;
    }

    public static void main(String[] args) {
        A2 a = new B2();
        a.disp(10);
        a.disp(new Integer(10));
        B2 b = new B2();
        b.disp(10);
        b.disp(new Integer(10));
        a.display();
        // a.display1(); Error
        b.display();
        System.out.println(x);
        System.out.println(new OverrideDemo().y);
    }
}
