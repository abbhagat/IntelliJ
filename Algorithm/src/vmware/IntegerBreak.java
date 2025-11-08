package vmware;

/**
 * Given an integer n, break it into the sum of k positive integers,
 * where k >= 2, and maximize the product of those integers.
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class IntegerBreak {

    private static int integerBreak(int n) {
        switch (n) {
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                int product = 1;
                while (n > 4) {
                    product *= 3;
                    n -= 3;
                }
                return product * n;
        }
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(10));
    }
}
