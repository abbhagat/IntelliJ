package leetcode;

import java.util.*;

// Time  Complexity	: O(2ⁿ) Since, O(2ⁿ) > O(givenSum log givenSum) therefore O(2ⁿ)
// Space Complexity	: O(givenSum)
public class _3Sum {

  private static Set<List<Integer>> combinationForSum(int index, int curSum, int givenSum, int[] a, LinkedList<Integer> list, Set<List<Integer>> set) {
    if (curSum == givenSum && list.size() == 3) {
      set.add(new LinkedList<>(list));
      return set;
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

  private static void combinationForSum(int index, int curSum, int givenSum, int[] a, LinkedList<Integer> list) {
    if (curSum == givenSum && list.size() == 3) {
      System.out.println(list);
      return;
    }
    for (int i = index; i < a.length; i++) {
      curSum += a[i];
      list.add(a[i]);
      combinationForSum(i + 1, curSum, givenSum, a, list);
      list.removeLast();
      curSum -= a[i];
    }
  }

  public static void main(String[] args) {
    int[] a = {-1, 0, 1, 2, -3, -4};
    Arrays.sort(a);
    System.out.println(combinationForSum(0, 0, 0, a, new LinkedList<>(), new HashSet<>()));
    System.out.println();
    System.out.println(combinationForSum(0, 0, -1, a, new LinkedList<>(), new HashSet<>()));
    System.out.println("--------------");
    combinationForSum(0, 0, 0, a, new LinkedList<>());
    System.out.println();
    combinationForSum(0, 0, -1, a, new LinkedList<>());
  }
}
