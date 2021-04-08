package enums;

interface I {

}

enum E1 implements I, Runnable {

    RED(10, "Red"),
    BLUE(20),
    GREEN;
    int price;

    private E1(int price) {
        this.price = price;
    }

    private E1(int price, String color) {
        this.price = price;
    }

    private E1() {
        this.price = 30;
    }

    public void run() {

    }
}

public class EnumDemo implements Runnable, I {
    public static void main(String[] args) {
        E1 e = E1.GREEN;
        System.out.println(e);
        System.out.println(e.GREEN.price + "\t" + e.ordinal());
        System.out.println(e.RED.price + "\t" + e.ordinal());
    }

    public void run() {
        System.out.println("Inside Run Method");
    }
}
