package leetcode;

import java.util.LinkedList;

// Time  Complexity : O(n * 2ⁿ)
// Space Complexity : O(n)
public class _3SumProblem {

  private static void combinationForSum(int[] a, int index, int currSum, int givenSum, LinkedList<Integer> list) {
    if (index == a.length) {
      if (currSum == givenSum && list.size() == 3) {
        System.out.println(list);
      }
      return;
    }
    currSum += a[index];
    list.add(a[index]);
    combinationForSum(a, index + 1, currSum, givenSum, list);
    currSum -= a[index];
    list.removeLast();
    combinationForSum(a, index + 1, currSum, givenSum,  list);
  }

  public static void main(String[] args) {
    int[] a = {-1, 0, 1, 2, -1, -4};
    combinationForSum(a, 0, 0, 0,  new LinkedList<>());
    System.out.println();
    combinationForSum(a, 0, 0, -1, new LinkedList<>());
  }
}
