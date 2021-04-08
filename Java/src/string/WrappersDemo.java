package string;

public class WrappersDemo {

    static void display(Long i) {
        System.out.println("long");
    }

    static void display(float i) {
        System.out.println("float");
    }

    static void display(Number i) {
        System.out.println("Number");
    }

    public static void main(String[] args) {
        display(10);
        Integer i1 = new Integer(10);
        display(i1);
        Integer i2 = 10;
        System.out.println(i1 != i2);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        Float d1 = 3.14f;
        Float d2 = 3.14f;
        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));
    }
}
