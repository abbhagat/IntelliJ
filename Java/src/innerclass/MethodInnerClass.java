package innerclass;

class A1 {

    private int z = 10;

    public void display() {
        // static final int x = 20; // Error
        final int x = 20;
        int z = 3;
        int k = 5;
        class B1 {
            private int y = 30;

            public void display() {
                System.out.println(x);
                System.out.println(A1.this.z);
                System.out.println(z);
                //System.out.println(k); // Error
                System.out.println(y);
            }
        }
        new B1().display();
        System.out.println(new B1().y);
    }
}

public class MethodInnerClass {
    public static void main(String[] args) {
        A1 a = new A1();
        a.display();
    }
}
