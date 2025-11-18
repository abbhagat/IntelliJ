package pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairsInArrayWhoseSumIsGivenNumber {

  public static void findPairs(int[] a, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(x -> map.merge(x, 1, Integer::sum));
    for (int x : a) {
      int y = target - x;
      if (map.containsKey(y)) {
        if (x == y && map.get(y) == 1) {
          continue;
        }
        System.out.println("(" + x + "," + y + ")");
        map.remove(x);
        map.remove(y);
      }
    }
  }

  public static void main(String[] args) {
    findPairs(new int[]{1, 2, 3, 4, 5}, 5);
    System.out.println();
    findPairs(new int[]{2, -3, 3, 3, -2}, 0);
    System.out.println();
    findPairs(new int[]{2, -6, 2, 5, 2}, 4);
  }
}
