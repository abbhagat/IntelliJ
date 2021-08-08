package enums;

import static java.lang.Math.pow;
import static java.lang.System.out;

public class StaticDemo {

    private int x;

    {
        x = 20;
    }

    public StaticDemo() {
        x = 10;
    }

    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        out.println(staticDemo.x);
        out.println((int) pow(staticDemo.x, 2));
    }
}
