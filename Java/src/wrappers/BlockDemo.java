package wrappers;

class A {
    static {
        System.out.println("A static block");
    }

    {
        System.out.println("A non static block");
    }

    A() {
        System.out.println("A constructor");
    }
}

class B extends A {
    static {
        System.out.println("B static block");
    }

    {
        System.out.println("B non static block");
    }

    B() {
        System.out.println("B constructor");
    }
}

public class BlockDemo {
    static {
        System.out.println("BlockDemo static block");
        String s = "Java";
        s.concat("is an OOP");
        System.out.println(s);
    }

    BlockDemo(){
        System.out.println("BlockDemo constructor");
    }
    {
        System.out.println("Non static block of Main Class");
    }

    public static void main(String[] args) {
        new BlockDemo();
        new B();
        new A();
        new B();
    }
}
