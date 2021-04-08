package enums;

class A3 {
    interface I1 {
        public abstract void display();
    }
}

class A4 implements A3.I1 {

    public void display() {

    }
}

public class Class3 {

    public static void main(String[] args) {
        new Class3();
        System.gc();
    }
}
