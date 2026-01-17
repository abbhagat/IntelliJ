package pairs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairsInArrayWhoseDivIsGivenNumber {

  public static void findPairs(int[] a, int k) {
    Set<Integer> set = new HashSet<>();
    Set<List<Integer>> result = new HashSet<>();
    if (k == 0) {
      for (int x : a) {
        if (x != 0) {
          result.add(List.of(x, 0));
        }
      }
    } else {
      for (int x : a) {
        if (set.contains(x / k)) {
          result.add(List.of(x, x / k));
        }
        if (set.contains(x * k)) {
          result.add(List.of(x, x * k));
        }
        set.add(x);
      }
    }
    System.out.println(result);
  }

  public static void main(String[] args) {
    findPairs(new int[]{5, 10, 5}, 1);
    findPairs(new int[]{12, 3, 6, 12, 8, 3, 24, 144, 0}, 0);
    findPairs(new int[]{12, 3, 6, 12, 8, 3, 24, 144, 1}, 12);
    findPairs(new int[]{8, 4, 2, 16, 32, 1, 0}, 2);
    findPairs(new int[]{5, 10, 20, 0}, 5);
    findPairs(new int[]{0, 0, 1}, 1);
  }
}
