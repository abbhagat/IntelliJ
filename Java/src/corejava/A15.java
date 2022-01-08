package corejava;

import access.AccessDemo;

public class A15 extends AccessDemo {
    int x;

    int display() {
        return super.x;
    }

    public static void main(String[] args) {
        System.out.println(new A15().display());
        System.out.println(new A8().display());
        int[] a = {1, 2, 3, 4, 5};
        int x = Integer.parseInt("123");
        for (int i : a) {
            System.out.println(i + "\t");
        }
        Integer i = new Integer("128");
        Integer j = new Integer("128");
        System.out.println(i == j);
        System.out.println(i.equals(j));
        System.out.println(i.hashCode() == j.hashCode());
        Character c1 = new Character('1');
        Character c2 = new Character('1');
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));
        System.out.println(c1.hashCode() == c2.hashCode());
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);
        System.out.println(i1.hashCode() == i2.hashCode());
        System.out.println(i1.equals(i2));
        i1 = 127;
        i2 = 127;
        System.out.println(i1 == i2);
        System.out.println(i1.hashCode() == i2.hashCode());
        System.out.println(i1.equals(i2));
    }
}

class A8 extends A15 {
    A8() {

        System.out.println(super.x);
        System.out.println(x);
    }
}
