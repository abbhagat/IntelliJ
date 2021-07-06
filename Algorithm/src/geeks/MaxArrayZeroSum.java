package geeks;

import java.util.HashMap;
import java.util.Map;

public class MaxArrayZeroSum {

    private static int maxLen(int[] a) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0, max_len = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0 && max_len == 0) {
                max_len = 1;
            }
            sum += a[i];
            if (sum == 0) {
                max_len = i;
            }
            Integer prev_i = hm.get(sum);        // Look this sum in hashmap
            if (prev_i != null) {               // If this sum is seen before, then update max_len if required
                max_len = Math.max(max_len, i - prev_i);
            } else {
                hm.put(sum, i);               // Else put this sum in hashmap
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        int a[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest Zero Sum subarray is " + maxLen(a));
    }
}
