package package2;

import package1.A;

public class B extends package1.A {
    protected int y = 100;

    private void display() {
        A a = new A();
        // System.out.println(super.x);
    }

    public static void main(String[] args) {
        new B().display();
    }
}
