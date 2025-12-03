package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllNumsDisappearedInArray {

  public static void findDisappearedNumbers(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
    int sum = map.values().stream().reduce(0, Integer::sum); // map.values().stream().reduce(0, (x, y) -> x + y);
    int min = Arrays.stream(a).min().orElse(0);
    for (int i = min; i < a.length || i <= sum; i++) {
      if (!map.containsKey(i)) {
        System.out.print(i + " ");
      }
    }
  }

  public static void main(String[] args) {
    findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 0});
    System.out.println();
    findDisappearedNumbers(new int[]{1, 1});
  }
}
