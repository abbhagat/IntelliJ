package geeks;

/**
 * Input : A[] = {2, 2, 1, 7, 5, 3}, k = 4
 * Output : 5
 * Explanation :
 * There are five pairs possible whose sum
 * is divisible by '4' i.e., (2, 2),
 * (1, 7), (7, 5), (1, 3) and (5, 3)
 * <p>
 * Input : A[] = {5, 9, 36, 74, 52, 31, 42}, k = 3
 * Output : 7
 * An efficient approach is to use Hashing technique. We will separate elements into buckets depending on their (value mod K).
 * When a number is divided by K then the remainder may be 0, 1, 2, upto (k-1).
 * So take an array say freq[] of size K (initialized with Zero) and increase the value of freq[A[i]%K]
 * so that we can calculate the number of values giving remainder j on division with K.
 */

public class CountPairsWithSumDivisibleByK {

    private static final int[] a = {2, 2, 1, 7, 5, 3};

    private static int countKdivPairs(int k) {

        int[] freq = new int[k];     // freq[] to count occurrences of all remainders when divided by k
        for (int x : a) {           // Count occurrences of all remainders
            freq[x % k]++;
        }
        int sum = freq[0] * (freq[0] - 1) / 2;                // If both pairs are divisible by 'k'
        for (int i = 1; i <= k / 2 && i != (k - i); i++) {    // count for all i and (k-i) freq pairs
            sum += freq[i] * freq[k - i];
        }
        if (k % 2 == 0) {                              // If k is even
            sum += freq[k / 2] * (freq[k / 2] - 1) / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.print(countKdivPairs(4));
    }
}
