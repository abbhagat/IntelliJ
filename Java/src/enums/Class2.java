package enums;

class A1 {
    static int x = 10;
    int y;

    A1() {
        System.out.println("A1 cons");
    }

    static {
        System.out.println("static A1");
        System.out.println(x);
        x = 100;
        // y = 100; // Error
    }

    {
        y = 100;
        System.out.println("Non static A1");
    }
}

class A2 extends A1 {
    A2() {
        System.out.println("A2 cons");
    }

    static {
        System.out.println("static A2");
    }

    {
        System.out.println("Non static A2");
    }
}

public class Class2 {

    static {
        System.out.println("Inside Class2 static block");
    }

    {
        System.out.println("Inside Class2 non-static block");
    }

    Class2() {
        System.out.println("Inside Class2 constructor");
    }

    public static void main(String[] args) {
        new A2();
    }
}
