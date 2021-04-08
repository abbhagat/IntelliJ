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
        out.println(new StaticDemo().x);
        out.println((int)pow(10, 2));
    }
}
