package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MissingNumber_1_to_25 {

  private static int findMissingNumberWhenNumbersIsRepeated(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
    int sum1 = Arrays.stream(a).sum();
    Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
    for (Map.Entry<Integer, Integer> m : entrySet) {
      if (m.getValue() > 1) {
        sum1 -= m.getKey();
        break;
      }
    }
    int n = a.length;
    int sum2 = ((a[0] + a[n - 1]) * n) / 2;
    return sum2 - sum1;
  }

  private static int findMissingNumberWhenNumbersIsNotRepeated(int[] a) {
    int n = a.length;
    int sum1 = Arrays.stream(a).sum();
    int sum2 = ((a[0] + a[n - 1]) * (n + 1)) / 2;
    return sum2 - sum1;
  }

  public static void main(String[] args) {
    System.out.println(findMissingNumberWhenNumbersIsRepeated(new int[]{1, 2, 3, 3, 5}));
    System.out.println(findMissingNumberWhenNumbersIsNotRepeated(new int[]{1, 2, 3, 5}));
  }
}
