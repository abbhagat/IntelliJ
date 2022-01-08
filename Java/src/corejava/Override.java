package corejava;

import static java.lang.System.out;

class A6 {
    static int s = 1000;

    A6(int x) {
        System.out.println("Super class Constructor");
    }

    A6 display() {
        out.println("Super");
        return new A6(10);
    }

    A6() {

    }

    static void disp() {
        System.out.println("A6");
    }
}

class A7 extends A6 {

    static void disp() {
        System.out.println(s);
    }

    A7() {
        super(10);
        System.out.println("Sub class Constructor");
        disp();
    }

    A7 display() {
        out.println("Sub");
        return new A7();
    }
}

class Test {

    public static void main(String[] arg) {
        A6 a = new A7();
        a.disp();
        String[] s = new String[]{"A", "B"};
        System.out.println(s instanceof Object);
        System.out.println(s[0] instanceof Object);
    }
}
