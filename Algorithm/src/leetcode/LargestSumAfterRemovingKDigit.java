package leetcode;

import static java.lang.Integer.max;

/**
 * Given a positive number N, the target is to find the largest number that can be formed after removing any K digits from N.
 * Examples:
 * Input: N = 6358, K = 1
 * Output: 658
 * Input: N = 2589, K = 2
 * Output: 89
 */
public class LargestSumAfterRemovingKDigit {

    private static int maxNumber(int n, int k) {
        for (int j = 1; j <= k; j++) {
            int result = Integer.MIN_VALUE;
            for (int i = 1; n / i > 0; i *= 10) {               // Remove the last digit after every iteration
                int temp = (n / (i * 10)) * i + (n % i);       // Store the numbers formed after removing every digit once
                result = max(result, temp);
            }
            n = result;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(maxNumber(6358, 1));
        System.out.println(maxNumber(2589, 2));
    }
}
