package statics;

import static java.lang.Math.pow;

public class StaticDemo {

    static int y = 10;
    static int x = 10;

    static {
        y = 20;
    }

    {
        x = 15;
        y = 100;
    }

    StaticDemo() {
        this.x = 20;
    }

    public static void main(String[] args) {
        System.out.println(y);
        System.out.println(new StaticDemo().y);
        System.out.println(pow(x, 2));
    }
}
