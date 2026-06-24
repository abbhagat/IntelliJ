package paypal;

import java.util.LinkedList;

/*
   Scenario                Time Complexity  Space Complexity
  ------------------------  ---------------  ----------------
  Ignoring output/printing  O(2ⁿ)                 O(n)
  Including printing cost   O(n·2ⁿ)               O(n)
*/
public class SubsetWithSumDivByN {

  private static void findSubset(int[] a, int i, int sum, int n, LinkedList<Integer> list) {
    if (i == a.length) {
      if (sum % n == 0 && !list.isEmpty()) {
        System.out.println(list);
      }
      return;
    }
    sum += a[i];
    list.add(a[i]);
    findSubset(a, i + 1, sum, n, list);
    sum -= a[i];
    list.removeLast();
    findSubset(a, i + 1, sum, n, list);
  }

  public static void main(String[] args) {
    findSubset(new int[]{1, 2, 4}, 0, 0, 3, new LinkedList<>());
    System.out.println("------------");
    findSubset(new int[]{10, 2, 4, 3, 1}, 0, 0, 5, new LinkedList<>());
  }
}
