package wrappers;

public class WrappersDemo {

    public static void main(String[] args) {

        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1.equals(i2));
        System.out.println(i1 == i2);
        Integer i = 128;
        Integer j = 128;
        System.out.println(i.equals(j));
        System.out.println(i == j);
        Integer i3 = new Integer(12);
        Integer i4 = new Integer(12);
        System.out.println(i3.equals(i4));
        System.out.println(i3 == i4);
        Integer i5 = new Integer(127);
        Integer i6 = 127;
        System.out.println(i6.equals(i5));
        System.out.println(i5 == i6);
        Integer i7 = 128;
        int x = 128;
        System.out.println(x == i7);
    }
}
