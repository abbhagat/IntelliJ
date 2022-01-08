package access;

public class AccessDemo {

    protected static int x = 3;
    protected int y = 4;
    static int[] b = {};

    void display() {
        System.out.println("Java");
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b;
//         synchronized(x){ // Error
//
//         }
        System.out.println(AccessDemo.b instanceof Object); // variable b might have not been initialized
        System.out.println(AccessDemo.b.length); // variable b might have not been initialized
        System.out.println(a);
        System.out.println(a.length);
        System.out.println(-10.0 / 0);
        System.out.println(10.0 / 0);
        System.out.println(-10 % 0.0);
        System.out.println(10 % 0.0);
        System.out.println(a instanceof Object);
        // System.out.println("xyz");
        // display(b); // variable b might have not been initialized
        // System.out.println(int instanceof Class);
        Integer x = 10;
        //System.out.println(x instanceof Class);
        // synchronized(this.b){
        synchronized (AccessDemo.b.getClass()) {
            System.out.println("Lock on java.lang.Class");
        }


        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3.hashCode() == i4.hashCode());
        System.out.println(i3.equals(i4));
        System.out.println(i3 == i4);
        i3 = new Integer(129);
        i4 = new Integer(129);
        System.out.println(i3.hashCode() == i4.hashCode());
        System.out.println(i3.equals(i4));
        System.out.println(i3 == i4);
        Integer i5 = new Integer(10);
        Integer i6 = 10;
        System.out.println(i5.hashCode() == i6.hashCode());
        System.out.println(i5.equals(i6));
        System.out.println(i5 == i6);
        Integer i7 = new Integer(1000);
        int i8 = 1000;
        //System.out.println(i7.hashCode()==i8.hashCode());
        System.out.println(i7.equals(i8));

        Float f1 = 1000f;
        Float f2 = 1000f;
        System.out.println(f1.hashCode() == f2.hashCode());
        System.out.println(f1.equals(f2));
        System.out.println(f1 == f2);
        Float f3 = new Float(1000f);
        Float f4 = new Float(1000f);
        System.out.println(f3 == f4);
        System.out.println(f3.hashCode() == f4.hashCode());
        System.out.println(f3.equals(f4));
        char[] c = {'J', 'a', 'v', 'a'};
        System.out.println(c);
    }
}
