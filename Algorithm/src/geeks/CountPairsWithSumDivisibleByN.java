package geeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private static final int[] a = {2, 1, 7, 5, 3, 2};
    private static int[] temp = new int[a.length];
    private static List<String> list = new ArrayList<>();
    private static Set<Integer> set = new HashSet<>();

    private static void countKdivPairs(int k) {
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i] % k;
            set.add(temp[i]);
        }
        int count = 0;
        for (int x : temp) {
            if (x == 0) {
                count++;
            } else if ((set.contains(k - x))) {
                if (x != k - x) {
                    list.add(x + "," + (k - x));
                } else if (!list.contains(x + "," + (k - x))) {
                    list.add(x + "," + (k - x));
                }
            }
        }
        System.out.println(count + list.size());
    }

    public static void main(String[] args) {
        countKdivPairs(4);
    }
}
