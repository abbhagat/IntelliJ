package geeks;

import static java.lang.Integer.max;

public class MaxSumNonAdjacentArray {

  private static int maxSumNonAdjacentArray(int[] a) {
    int incl = a[0], excl = 0;
    for (int i = 1; i < a.length; i++) {
      int excl_new = max(incl, excl);
      incl = excl + a[i];
      excl = excl_new;
    }
    return max(incl, excl);
  }

  private static int maxSumNonAdjacentArray(int[] a, int n) {
    if(n < 0) {
      return 0;
    }
    int selected = a[n] + maxSumNonAdjacentArray(a, n - 2);
    int unselected = maxSumNonAdjacentArray(a, n - 1);
    return max(selected, unselected);
  }

  private static int maxSumNonAdjacentArrayDP(int[] a) {
    int n = a.length - 1;
    int[] dp = new int[n + 1];
    dp[0] = a[0];
    dp[1] = max(a[0], a[1]);
    for(int i = 2; i <= n; i++) {
      dp[i] = max(dp[i - 1], a[i] + dp[i - 2]);
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(maxSumNonAdjacentArray(new int[]{1, 2, 3}));
    System.out.println(maxSumNonAdjacentArray(new int[]{1, 2, 3}, 2));
    System.out.println(maxSumNonAdjacentArrayDP(new int[]{1, 2, 3}));
    System.out.println(maxSumNonAdjacentArray(new int[]{1, 20, 3}));
    System.out.println(maxSumNonAdjacentArray(new int[]{1, 20, 3}, 2));
    System.out.println(maxSumNonAdjacentArrayDP(new int[]{1, 20, 3}));
    System.out.println(maxSumNonAdjacentArray(new int[]{3, 2, 7, 10}));
    System.out.println(maxSumNonAdjacentArray(new int[]{3, 2, 7, 10}, 3));
    System.out.println(maxSumNonAdjacentArrayDP(new int[]{3, 2, 7, 10}));
    System.out.println(maxSumNonAdjacentArray(new int[]{3, 2, 5, 10, 7}));
    System.out.println(maxSumNonAdjacentArrayDP(new int[]{3, 2, 5, 10, 7}));
    System.out.println(maxSumNonAdjacentArray(new int[]{5, 5, 10, 100, 10, 5}));
    System.out.println(maxSumNonAdjacentArrayDP(new int[]{5, 5, 10, 100, 10, 5}));
  }
}
