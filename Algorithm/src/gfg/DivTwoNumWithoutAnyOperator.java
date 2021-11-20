package gfg;

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
        divide(Math.max(x, y), Math.min(x, y));
        divide(Math.max(x, y), Math.min(x, y),0);
    }
}
