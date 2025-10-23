package arrays;

import java.util.*;

public class PrintRepeatingNumInArray {

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 100, 3, 6, 6, 4, 5, 3, 5, 4, 3};
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(n -> {
      map.put(n, map.getOrDefault(n, 0) + 1);
    });
    Set<Map.Entry<Integer, Integer>> set = map.entrySet();
    for (Map.Entry<Integer, Integer> m : set) {
      if (m.getValue() > 1) {
        System.out.print(m.getKey() + " ");
      }
    }
  }
}
