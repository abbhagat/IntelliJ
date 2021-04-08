package package3;

import package2.B;

public class C extends B {
    private void display() {
        // System.out.println(super.x);
    }

    public static void main(String[] args) {
        new C().display();
    }
}
