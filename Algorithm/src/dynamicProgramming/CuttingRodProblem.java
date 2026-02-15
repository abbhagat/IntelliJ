package dynamicProgramming;

import static java.lang.Integer.max;

// Time  Complexity: O(2^n) where n is the length of the price array
// Space Complexity: O(n)   where n is the length of the price array
public class CuttingRodProblem {

  private static int cutRod(int[] price, int n) {
    if (n == 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int res = price[i] + cutRod(price, n - i - 1);
      max = max(max, res);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] price;
    price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
    System.out.println(cutRod(price, price.length));
    price = new int[]{1, 2, 3, 4, 5};
    System.out.println(cutRod(price, price.length));
  }
}
