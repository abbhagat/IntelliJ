package microsoft;

import java.util.HashMap;
import java.util.Map;

/**
Given an array with n positive integers. We need to find the minimum number of operation to make all elements equal.
We can perform addition, multiplication, subtraction or division with any element on an array element.

Example
If input array is = {1, 2, 3, 4} then we require minimum 3 operations to make all elements equal.
For example, we can make elements 4 by doing 3 additions.
 */

public class MinOpsToMakeAllArrayElementsSame {

    private static int printMinOps(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (max < set.getValue()) {
                max = set.getKey();
            }
        }
        return a.length - max;
    }

    public static void main(String[] args) {
        System.out.println(printMinOps(new int[]{1, 2, 3, 4}));
    }
}
