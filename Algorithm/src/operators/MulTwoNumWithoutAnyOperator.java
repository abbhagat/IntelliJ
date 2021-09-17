package operators;

public class MulTwoNumWithoutAnyOperator {

    private static int add(int x, int y) {
        return y == 0 ? x : add(x ^ y, (x & y) << 1);
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 15;
        int mul = 0;
        for (int i = 1; i <= Math.min(x, y); i++) {
            mul = add(mul, Math.max(x, y));
        }
        System.out.println(mul);
    }
}
