package pairs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class FindPairsInArrayWhoseSumIsGivenNumber {

  public static void findPairs(int[] a, int n) {
    Set<Integer> set = new HashSet<>();
    Set<List<Integer>> resultSet = new HashSet<>();
    for (int x : a) {
      int y = n - x;
      if (set.contains(y)) {
        int min  = min(x, y);
        int max  = max(x, y);
        resultSet.add(List.of(min, max));
      }
      set.add(x);
    }
    System.out.println(resultSet);
  }

  public static void main(String[] args) {
    findPairs(new int[]{1, 2, 3, 4, 5}, 5);
    findPairs(new int[]{2, -3, 3, 3, -2}, 0);
    findPairs(new int[]{2, -6, 2, 5, 2}, 4);
  }
}
