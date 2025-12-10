package leetcode;

import java.util.*;

// Time  Complexity : O(2^n)
// Space Complexity : O(n)
public class _3Sum {

  private static Set<List<Integer>> combinationForSum(int index, int curSum, int givenSum, int[] a, LinkedList<Integer> list, Set<List<Integer>> set) {
    if (curSum == givenSum && list.size() == 3) {
      set.add(new LinkedList<>(list));
    }
    for (int i = index; i < a.length; i++) {
      curSum += a[i];
      list.add(a[i]);
      combinationForSum(i + 1, curSum, givenSum, a, list, set);
      list.removeLast();
      curSum -= a[i];
    }
    return set;
  }

  private static void combinationForSum(int[] a, int index, int sum, int n, LinkedList<Integer> list) {
    if (index == a.length) {
      if (sum == n && !list.isEmpty()) {
        System.out.println(list);
      }
      return;
    }
    sum += a[index];
    list.add(a[index]);
    combinationForSum(a, index + 1, sum, n, list);
    sum -= a[index];
    list.removeLast();
    combinationForSum(a, index + 1, sum, n,  list);
  }

  public static void main(String[] args) {
    int[] a = {-1, 0, 1, 2, -1, -4};
    Arrays.sort(a);
    System.out.println(combinationForSum(0, 0,  0, a, new LinkedList<>(), new HashSet<>()));
    System.out.println(combinationForSum(0, 0, -1, a, new LinkedList<>(), new HashSet<>()));
    System.out.println("--------------");
    combinationForSum(a, 0, 0, 0, new LinkedList<>());
  }
}
