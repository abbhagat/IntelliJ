package geeks;

import java.util.HashMap;
import java.util.Map;
import static java.lang.Integer.max;

// Time  Complexity: O(n)
// Space Complexity: O(n)
public class LongestZeroSumSubArray {

    private static int longestZeroSumSubArray(int[] a, int n) {
        Map<Integer, Integer> map = new HashMap<>();  // to store key as zero-sum with the value as index
        int sum = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum == n) {
                max = i + 1;
            }
            if (map.containsKey(sum)) {
                max = max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestZeroSumSubArray(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 0));
        System.out.println(longestZeroSumSubArray(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 25));
        System.out.println(longestZeroSumSubArray(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 33));
        System.out.println(longestZeroSumSubArray(new int[]{1, -2, 2, -8, 1, 7, -1}, 0));
        System.out.println(longestZeroSumSubArray(new int[]{1, -2, 2, -8, 1, 7, -1}, 1));
    }
}
