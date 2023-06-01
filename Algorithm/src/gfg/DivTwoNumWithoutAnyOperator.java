package gfg;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class DivTwoNumWithoutAnyOperator {

    private static void divide(int x, int y) {
        int q = 0;
        while (x >= y) {
            x -= y;
            q++;
        }
        System.out.println("Quotient  :" + q);
        System.out.println("Remainder :" + x);
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
