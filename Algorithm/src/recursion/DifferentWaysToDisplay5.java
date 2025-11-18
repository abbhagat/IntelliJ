package recursion;

import java.util.Objects;

// Time  Complexity: O(2^n)
// Space Complexity: O(n)
public class DifferentWaysToDisplay5 {

  private static int count = 0;

  private static void countWays(String prefix, int n) {
    if (n == 0) {
      count++;
      System.out.println(prefix);
      return;
    }
    for (int i = 1; i <= n; i++) {
      String newPrefix = prefix + (Objects.equals(prefix, "") ? "" : "+") + i;
      //String newPrefix = prefix + i;
      countWays(newPrefix, n - i);
    }
  }

  private static void uniqueCountWays(String prefix, int n, int iterations) {
    if (n == 0) {
      count++;
      System.out.println(prefix);
      return;
    }
    for (int i = 1; i <= n && i <= iterations; i++) {
      String s = prefix == "" ? "" : "+";
      String newPrefix = prefix + s + i;
      uniqueCountWays(newPrefix, n - i, i);
    }
  }

  public static void main(String[] args) {
    countWays("", 5);
    System.out.println("Count : " + count);
    System.out.println();
    count = 0;
    uniqueCountWays("", 5, 5);
    System.out.println("Count : " + count);
  }
}
