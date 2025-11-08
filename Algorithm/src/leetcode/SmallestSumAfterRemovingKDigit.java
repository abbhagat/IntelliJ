package leetcode;

import static java.lang.Integer.min;

/**
 * Given a positive number N, the target is to find the largest number that can be formed after removing any K digits from N.
 * Examples:
 * Input: N = 6358, K = 1
 * Output: 358
 * Input: N = 2589, K = 2
 * Output: 25
 */
public class SmallestSumAfterRemovingKDigit {
    private static int minNumber(int n, int k) {
        if (String.valueOf(n).length() == k) {
            return 0;
        }
        for (int j = 1; j <= k; j++) {
            int min = Integer.MAX_VALUE, result;
            for (int i = 1; n / i != 0; i *= 10) {     // Remove the last digit after every iteration
                result = n / (i * 10) * i + (n % i);  // Store the numbers formed after removing every digit once
                min = min(min, result);
            }
            n = min;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(minNumber(10, 2));
        System.out.println(minNumber(6358, 1));
        System.out.println(minNumber(2589, 2));
        System.out.println(minNumber(10200, 1));
        System.out.println(minNumber(1432219, 3));
    }
}
