package serialize;

class B extends access.AccessDemo {
    protected int y = 5;

    {
        x = 25;
    }
}

public class AccesDemo extends B {
    protected int y = 15;

    void display() {
        System.out.println(x);
        System.out.println(y);
    }

    public static void main(String[] args) {
        B b = new AccesDemo();
        System.out.println(b.y);
        System.out.println(b.x);
        System.out.println(x);
        new AccesDemo().display();
    }
}
