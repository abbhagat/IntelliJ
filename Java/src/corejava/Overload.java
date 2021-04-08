package corejava;

import java.io.IOException;

interface I {

}

class Super implements I {
    protected void display(int i) throws IOException {
        System.out.println("Super");
    }
}

class Sub extends Super {
    void display(Integer i) {
        System.out.println("Sub");
    }
}

public class Overload {
    public static void main(String[] args) throws IOException {
        Super s1 = new Sub();
        System.out.println(s1 instanceof Super);
        System.out.println(s1 instanceof Sub);
        System.out.println(s1 instanceof I);
        s1.display(new Integer(10));
        s1.display(10);
        Super s2 = new Super();
        System.out.println(s2 instanceof Super);
        System.out.println(s2 instanceof Sub);
        System.out.println(s2 instanceof I);
        s2.display(10);
        Integer i1 = 1000;
        int i2 = 1000;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(1 / 2);
        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));
        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));
        System.out.println(i5.hashCode() + "\t" + i6.hashCode());
        Sub s = new Sub();
    }
}
