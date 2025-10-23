package vmware;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Given an array of integers, every element appears twice except for one which appears exactly once. Find that number.
// Time Complexity O(n)
public class SingleNumber {

  private static int singleNumber(int[] a) {
    int n = 0;
    for (int x : a) {
      n ^= x;
    }
    return n;
  }

  private static int singleNumberWithMap(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(x -> map.merge(x, 1, Integer::sum));
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] a = {2, 2, 1};
    System.out.println(singleNumber(a) + "\t" + singleNumberWithMap(a));
    int[] b = {4, 1, 2, 1, 2};
    System.out.println(singleNumber(b) + "\t" + singleNumberWithMap(b));
  }
}
