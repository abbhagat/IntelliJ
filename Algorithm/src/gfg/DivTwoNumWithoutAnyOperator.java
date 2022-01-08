package gfg;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class DivTwoNumWithoutAnyOperator {

    private static int divide(int x, int y) {
        int c = 0;
        while (x >= y) {
            x -= y;
            c++;
        }
        System.out.println("Quotient  :" + c);
        System.out.println("Remainder :" + x);
        return c;
    }

    private static void divide(int x, int y, int c) {
        if (x >= y) {
            divide(x - y, y, ++c);
        } else {
            System.out.println("Quotient  :" + c);
            System.out.println("Remainder :" + x);
        }
    }

    public static void main(String[] args) {
        int x = 16, y = 3;
        divide(max(x, y), min(x, y));
        divide(max(x, y), min(x, y), 0);
    }
}
