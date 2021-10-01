package leetcode;

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
            int ans = 0, i = 1;
            while (n / i > 0) {                                // Remove the last digit after every iteration
                int temp = (n / (i * 10)) * i + (n % i);      // Store the numbers formed after removing every digit once
                i *= 10;
                ans = Math.max(ans, temp);
            }
            n = ans;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(maxNumber(6358, 1));
    }
}
