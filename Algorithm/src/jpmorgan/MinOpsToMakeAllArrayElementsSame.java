package microsoft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<Map.Entry<Integer, Integer>> list = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        int max = list.get(0).getKey();
        return Math.abs(max - a.length);
    }

    public static void main(String[] args) {
        System.out.println(printMinOps(new int[]{1, 2, 3, 4}));
    }
}
