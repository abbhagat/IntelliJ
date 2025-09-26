package pairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time  Complexity : O(n + k)
// Space Complexity : O(k)
public class FindPairCountWithSumDivisibleByK {

    private static void findPairs(int[] a, int k) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((a[i] + a[j]) % k == 0) {
                    int min = min(a[i], a[j]);
                    int max = max(a[i], a[j]);
                    String pair = min + "," + max;
                    if (set.add(pair)) {
                        System.out.println("(" + min + "," + max + ")");
                        count++;
                    }
                }
            }
        }
        System.out.println("Pair Count : " + count);
    }

    private static void findPairCount(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int x : a) {
             int y = x % k;
             int z = (k - y) % k;  // complement
             count += map.getOrDefault(z, 0);
             map.merge(y, 1, Integer::sum);
        }
        System.out.println("Pair Count : " + count);
    }

    private static int countPairs(int[] a, int k) {
        int[] freq = new int[k];
        for (int x : a) {
            freq[x % k]++;  // keeps the count of each remainder
        }
        int count = freq[0] * (freq[0] - 1) / 2;  // Counting Pairs with Remainder 0
        for (int i = 1; i <= k / 2 && i != (k - i); i++) {  // Counting Pairs with Remainders i and k-i
            count += freq[i] * freq[k - i];
        }
        count += k % 2 == 0 ? freq[k / 2] * (freq[k / 2] - 1) / 2 : 0;  // Counting Pairs with Remainder k/2 if k is even
        return count;
    }

    public static void main(String[] args) {
        findPairs(new int[]{1, 2, 3, 4, 5, 8}, 5);
        System.out.println(countPairs(new int[]{1, 2, 3, 4, 5, 8}, 5));
        findPairs(new int[]{1, 2, 3, 4, 5, 8}, 4);
        System.out.println(countPairs(new int[]{2, 2, 1, 7, 5, 3}, 4));
        findPairs(new int[]{2, 3, 5, 10}, 5);
        System.out.println(countPairs(new int[]{2, 3, 5, 10}, 5));
    }
}
