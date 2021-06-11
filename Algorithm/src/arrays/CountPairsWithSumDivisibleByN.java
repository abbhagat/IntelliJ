package arrays;

import java.util.LinkedHashMap;
import java.util.Map;

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

public class CountPairsWithSumDivisibleByN {

    //private static final int[] a = {2, 1, 7, 5, 3, 2};
    private static final int[] a = {5, 9, 36, 74, 52, 31, 42};
    private static Map<Integer, Integer> map = new LinkedHashMap<>();

    private static void countKdivPairs(int n) {
        for (int i = 0; i < a.length; i++) {
            map.put(i, a[i] % n);
        }
        System.out.println(map);
        int count = 0;
        for (int x : a) {
            int mod = x % n;
            int num = n - mod;
            if(map.containsValue(num)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        countKdivPairs(3);
    }
}
