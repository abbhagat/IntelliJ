package gfg;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class DivTwoNumWithoutAnyOperator {

    private static void divide(int x, int y) {
        int q = 0;
        while (x >= y) {
            x = sub(x, y);
            q++;
        }
        System.out.println("Quotient  :" + q);
        System.out.println("Remainder :" + x);
    }

    private static int sub(int x, int y) {
        return y == 0 ? x : sub(x ^ y, (~x & y) << 1);
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
