package core;

interface I {
    int x = 10;
}

public class Identifier extends Object implements I {
    private static int x;
    {
        x = 100;
    }

    private void display() {
        System.out.println(x);
    }

    public static void main(String[] args) {
        String String = "Java";
        System.out.println(String);
        System.out.println(x);  // 0 as it is initalized in non static block
        // I.x=10; //error as it is a final variable so it cannot be reassigned the value
        new Identifier().display();
        System.out.println(x);
        synchronized (I.class) {
            System.out.println(I.x);
        }
    }
}
