package utildemo;

import java.io.IOException;

class A1 {
    protected A1 aMethod(float a, float b) throws IOException {
        return new A1();
    }
}

class B1 extends A1 {

    @Override
    public B1 aMethod(float a, float b) {
        System.out.println("B1 class aMethod()");
        return new B1();
    }
}

public final class Example {
    public static void main(String[] args) throws IOException {
        Integer i = new Integer(0);
        Number f = new Float(0);
        System.out.println(i == f);
        System.out.println(i.equals(f));
        String s = "Java";
        Object o = null;
        StringBuffer s1 = new StringBuffer();
        System.out.println(s1 == null);
        System.out.println(null == null);
        A1 a1 = new B1();
        a1.aMethod(10, 20);


    }
}
