package access;

class A {
    static {
        System.out.println("A static block");
    } {
        System.out.println("A non static block");
    }

    A() {
        System.out.println("A constructor");
    }
}

class B {
    static {
        System.out.println("B static block");
    } {
        System.out.println("B non static block");
    }

    B() {
        System.out.println("B constructor");
    }
}

class StaticNonStaticBlock {
    static {
        System.out.println("BlockDemo static block");
        String s = "Java";
        s.concat("is an OOP");
        System.out.println(s);
    }

    public static void main(String[] args) {
        new B();
        new A();
    }
}
