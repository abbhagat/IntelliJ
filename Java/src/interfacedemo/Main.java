package interfacedemo;

interface I {
    int x = 10;

    void display();
}

interface I2 extends I {
    int x = 15;

    void display();
}

public class Main {
    static int x = 20;

    public static void main(String[] args) {
        System.out.println(I2.x);
        String s = " ";
        System.out.println(s.trim());
    }

    public int display() {
        return 0;
    }
}
