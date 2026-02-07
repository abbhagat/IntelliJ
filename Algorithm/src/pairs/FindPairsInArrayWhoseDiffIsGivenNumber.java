package pairs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class FindPairsInArrayWhoseDiffIsGivenNumber {

  public static void findPairs(int[] a, int k) {
    // Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());  // when you consider (x,y) and (y,x) pairs in result
    Set<Integer> set = new HashSet<>();
    Set<List<Integer>> resultSet = new HashSet<>();
    for (int x : a) {
      if (set.contains(x - k)) {
        resultSet.add(List.of(x, x - k));
      }
      if (set.contains(x + k)) {
        resultSet.add(List.of(x, x + k));
      }
      set.add(x);
    }
    System.out.println(resultSet);
  }

  public static void main(String[] args) {
    findPairs(new int[]{2, 6, 7, 1, 8, 3, 5, 5, 4, 5}, 4);
    findPairs(new int[]{10, 5, 15, 5, 0}, 5);
    findPairs(new int[]{10, 5, 15}, 5);
    findPairs(new int[]{10, 5, 15, 5, 0}, 0);
    findPairs(new int[]{1, 3}, 2);
    findPairs(new int[]{5, 0}, 5);
    findPairs(new int[]{5, 5, 5}, 0);
  }
}
