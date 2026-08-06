package pairs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time  Complexity: O(n)
// Space Complexity: O(n)
public class FindPairsInArrayWhoseProductIsGivenNumber {

  public static void findPairs(int[] a, int n) {
    Set<Integer> set = new HashSet<>();
    Set<List<Integer>> result = new HashSet<>();
    for (int x : a) {
      if (x == 0) {
        if (n == 0) {
          for (int y : set) {
            result.add(List.of(min(x, y), max(x, y)));
          }
        }
      } else {
        if (n % x == 0) {
          int y = n / x;
          if (set.contains(y)) {
            result.add(List.of(min(x, y), max(x, y)));
          }
        }
      }
      set.add(x);
    }
    System.out.println(result);
  }

  public static void main(String[] args) {
    int[] a = new int[]{12, 3, 6, 2, 12, 8, 3, 4, 144, 1};
    findPairs(a, 12);
    System.out.println();
    findPairs(a, 24);
    System.out.println();
    findPairs(a, 144);
  }
}
