package geeks;

import java.util.Arrays;
import java.util.LinkedList;

// Time  Complexity: O(2^n)
// Space Complexity: O(n)
public class ArraySum {

  public static void combinationForSum(int index, int currSum, int givenSum, int[] a, LinkedList<Integer> list) {
    if (currSum == givenSum && !list.isEmpty()) {
      System.out.println(list);
      return;
    }
    for (int i = index; i < a.length; i++) {
      currSum += a[i];
      list.add(a[i]);
      combinationForSum(i + 1, currSum, givenSum, a, list);
      list.removeLast();
      currSum -= a[i];
    }
  }

  public static void main(String[] args) {
    int[] a = {0, 15, -2, 2, -8, 1, 7, 10, 23};
    Arrays.sort(a);  // If the array is sorted, we can stop exploring branches early when the sum exceeds the target.
    combinationForSum(0, 0, 0, a, new LinkedList<>());
    System.out.println();
    combinationForSum(0, 0, 5, a, new LinkedList<>());
  }
}
