package geeks;

import java.util.*;

// Time  Complexity : O(n*2^n)
// Space Complexity : O(n)
public class MaxArrayGivenSum {

  public static void combinationForSum(int[] a, int index, List<Integer> list, int givenSum, int curSum, Set<List<Integer>> set) {
    if (curSum == givenSum && !list.isEmpty()) {
      set.add(new ArrayList<>(list));
      return;
    }
    for (int i = index; i < a.length; i++) {
      curSum += a[i];
      list.add(a[i]);
      combinationForSum(a, i + 1, list, givenSum, curSum, set);
      list.remove(list.size() - 1);
      curSum -= a[i];
    }
  }

  public static void main(String[] args) {
    int[] a = {-1, 0, 1, 2, -1, -4};
    Arrays.sort(a);
    Set<List<Integer>> set = new HashSet<>();
    combinationForSum(a, 0, new ArrayList<>(), 0, 0, set);
    System.out.println(set);
  }
}
