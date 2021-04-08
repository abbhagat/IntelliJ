package string;

public class WideningDemo {

    static void display(Byte b1, Byte b2) {
        System.out.println("Byte,Byte");
    }

    static void display(int b1, int b2) {
        System.out.println("int b1,int b2");
    }

    static void display(int b1) {
        System.out.println("int b1");
    }

    static void display(int b1, byte b2) {
        System.out.println("int b1,byte b2");
    }

    static void display(byte... b) {
        System.out.println("byte...b");
    }

    public static void main(String[] args) {
        byte b = 2;
        display(b);
        display(b, b);
        display(b, b, b);
        Byte byt = 2;
        display(byt, byt);
        display(10, 10);
    }
}
