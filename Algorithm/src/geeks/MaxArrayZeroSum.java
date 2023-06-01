package geeks;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.max;

public class MaxArrayZeroSum {

    private static int maxLen(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, max_len = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0 && max_len == 0) {
                max_len = 1;
            }
            sum += a[i];
            if (sum == 0) {
                max_len = i;
            }
            if (map.containsKey(sum)) {
                max_len = max(max_len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] a = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest Zero Sum subarray is " + maxLen(a));
    }
}
