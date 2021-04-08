package corejava;

public class ABC {

    static void display(float x) {
        System.out.println("float");
    }

    static void display(Object x) {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        Short s = 5;
        display(s);
    }
}
