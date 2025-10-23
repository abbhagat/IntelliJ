package jpmorgan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of N elements. Find the majority element in the array.
 * A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 * Input: N = 3 A[] = {1,2,3} Output: -1
 * Explanation: Since each element in {1,2,3} appears only once, so there is no majority element.
 * Input: N = 5 A[] = {3,1,3,3,2} Output: 3
 * Explanation: Since, 3 is present more than N/2 times, so it is the majority element.
 */

// Time Complexity: O(n)
// Auxiliary Space: O(1)
public class MajorityElement {

  private static int majorityElement(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(n -> map.merge(n, 1, Integer::sum));
    return Arrays.stream(a).filter(n -> map.get(n) > a.length / 2).findFirst().orElse(-1);
  }

  public static void main(String[] args) {
    System.out.println(majorityElement(new int[]{1, 2, 3}));
    System.out.println(majorityElement(new int[]{3, 1, 3, 3, 2}));
    System.out.println(majorityElement(new int[]{3, 1, 3, 2, 2, 2, 2, 2, 2, 4}));
  }
}
