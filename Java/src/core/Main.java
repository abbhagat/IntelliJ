package core;

class A {

}

class B extends A {

}

public class Main {
    public static void main(String[] args) {
        //System.out.println(null.equals(new A())); // NPE
        System.out.println(new A().equals(null));  // false
        System.out.println(null == null);  // true
        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        A[] a;
        B[] b;

        a = new A[10];
        b = new B[20];

        a = b; // (1)
        b = (B[]) a; // (2)

        a = new A[10];
        b = (B[]) a; // (3) ClassCastException
    }
}
