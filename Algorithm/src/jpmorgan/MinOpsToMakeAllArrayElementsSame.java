package jpmorgan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given an array with n positive integers. We need to find the minimum number of operations to make all elements equal.
 * We can perform addition, multiplication, subtraction or division with any element on an array element.
 * For Example, If an input array is = {1, 2, 3, 4} then we require minimum 3 operations to make all elements equal.
 * For example, we can make elements 4 by doing 3 additions.
 */

public class MinOpsToMakeAllArrayElementsSame {

  private static int printMinOps(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
    int max = 0;
    for (Map.Entry<Integer, Integer> set : map.entrySet()) {
      max = max < set.getValue() ? set.getKey() : max;
    }
    return a.length - max;
  }

  public static void main(String[] args) {
    System.out.println(printMinOps(new int[]{1, 2, 3, 4}));
  }
}
