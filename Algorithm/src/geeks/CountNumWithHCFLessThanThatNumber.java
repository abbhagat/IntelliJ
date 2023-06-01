package geeks;

/**
 * Given an integer N, the task is to count the values of K ( where 1 ≤ K≤ N ), such that 1< GCD(K, N) < K.
 * Examples:
 * Input: N = 10
 * Output: 3
 * Explanation: The values of K which satisfies the given conditions are:
 * K = 4, gcd(4, 10) = 2
 * K = 6, gcd(6, 10) = 2
 * K = 8, gcd(8, 10) = 2
 * Input: N = 15
 * Output: 4
 * Explanation: The values of K which satisfies the given conditions are:
 * K = 6,  gcd(6, 15)  = 3
 * K = 9,  gcd(9, 15)  = 3
 * K = 10, gcd(10, 15) = 5
 * K = 12, gcd(12, 15) = 3
 */
public class CountNumWithHCFLessThanThatNumber {

    private static int findHCF(int x, int y) {
        return y == 0 ? x : findHCF(y, x % y);
    }

    private static int findGCD(int x, int y) {
        int gcd = 0;
        for(int i = 1; i <= x || i <=y ; i++) {
            if(x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        int n = 15, count = 0;
        for (int i = 1; i <= n; i++) {
            int hcf = i;
            hcf = findGCD(hcf, n);
            if (hcf > 1 && hcf < i) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(findHCF(0, 5)  + "\t" + findGCD(0, 5));
        System.out.println(findHCF(5, 0)  + "\t" + findGCD(5, 0));
        System.out.println(findHCF(5, 10) + "\t" + findGCD(5, 10));
        System.out.println(findHCF(10, 5) + "\t" + findGCD(10, 5));
    }
}
