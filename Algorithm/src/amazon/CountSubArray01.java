package amazon;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class CountSubArray01 {

    public static int getSubArrayWithEqual01(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = -1;
            }
            sum += a[i];
            if (sum == 0) {
                count++;
            }
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Sub-arrays with equal 0's and 1's count is: " + getSubArrayWithEqual01(new int[]{0, 0, 1, 1, 0}));
    }
}
