package jpmorgan;

/**
 * Given an integer n, return the smallest prime palindrome greater than or equal to n.
 * An integer is prime if it has exactly two divisors: 1 and itself. Note that 1 is not a prime number.
 * For example, 2, 3, 5, 7, 11, and 13 are all primes.
 * An integer is a palindrome if it reads the same from left to right as it does from right to left.
 * For example, 101 and 12321 are palindromes.
 * The test cases are generated so that the answer always exists and is in the range [2, 2 * 108].
 * Example 1:
 * Input: n = 6
 * Output: 7
 * Example 2:
 * <p>
 * Input: n = 8
 * Output: 11
 * Example 3:
 * <p>
 * Input: n = 13
 * Output: 101
 */

public class PrimePalindrome {

    private static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public static boolean isPrime(int n) {
        switch (n) {
            case 0:
            case 1:
                return false;
            case 2:
                return true;
            default:
                for (int i = 2; i <= n / 2; i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
        }
    }

    private static int primePalindrome(int n) {
        while (true) {
            if (isPalindrome(n) && isPrime(n)) {
                return n;
            }
            n++;
            // Code added to pass in HackerRank
            if (n > 10_000_000 && n < 100_000_000) {
                n = 100_000_001;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(primePalindrome(13));
    }
}
