package arrays;

public class MulTwoNumWithoutAnyOperator {

    private static int mul(int sum, int x, int y, int itr) {
        if (itr == 0) {
            return sum;
        } else {
            while (y != 0) {
                int carry = (x & y) << 1;
                x = x ^ y;
                y = carry;
            }
            return (mul(x, x, x, itr - 2));
        }
    }

    private static int add(int x, int y) {
        return y == 0 ? x : add(x ^ y, (x & y) << 1);
    }


    public static void main(String[] args) {
        System.out.println(mul(0, 15, 15, 6));
        int x = 3;
        int y = 15;
        int mul = 0;
        for (int i = 1; i <= y; i++) {
            mul = add(mul, x);
        }
        System.out.println(mul);
    }

}
