package pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Time  Complexity: O(n * sqrt(sum))   [ O(n) + O(√sum) + O(n * m) ]
// Space Complexity: O(√sum) + O(n)
public class FindPairsWithPerfectSquareSum {

  private static int maxPairSum(int[] a) {
    int max = Integer.MIN_VALUE, _2ndMax = Integer.MIN_VALUE;
    for (int x : a) {
      if (max < x) {
        _2ndMax = max;
        max = x;
      } else if (_2ndMax < x) {
        _2ndMax = x;
      }
    }
    return max + _2ndMax;
  }

  private static List<Integer> getPerfectSquares(int sum) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i * i < sum; i++) {
      list.add(i * i);
    }
    return list;
  }

  private static int countPairs(int x, List<Integer> list, Set<Integer> set) {
    int count = 0;
    for (int target : list) {
      int y = target - x;
      if (y > x && set.contains(y)) {       // y > x is checked so that pairs (x, y) and (y, x) don't get counted twice
        System.out.print("(" + x + "," + y + ")" + "  ");
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 5, 6, 9, 10, 20, 30};
    int sum = maxPairSum(a);
    List<Integer> list = getPerfectSquares(sum);
    Set<Integer> set   = Arrays.stream(a).boxed().collect(Collectors.toSet());
    int count = 0;
    for (int x : a) {
      count += countPairs(x, list, set);
    }
    System.out.println("\nPair Count : " + count);
  }
}
