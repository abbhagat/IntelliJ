package gfg;

public class DivTwoNumWithoutAnyOperator {

    private static int divide(int x, int y) {
        int c = 0;
        while (x >= y) {
            x -= y;
            c++;
        }
        System.out.println("Quotient :" + c);
        System.out.println("Remainder :" + x);
        return c;
    }

    public static void main(String[] args) {
        int x = 16;
        int y = 3;
        System.out.println(divide(Math.max(x, y), Math.min(x, y)));
    }
}
