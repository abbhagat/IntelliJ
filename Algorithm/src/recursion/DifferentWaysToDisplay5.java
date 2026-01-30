package recursion;

// Time  Complexity: O(2^n)
// Space Complexity: O(n)
public class DifferentWaysToDisplay5 {

  static class Count {
    int count;
  }

  private static void countWays(String prefix, int n, Count count) {
    if (n == 0) {
      count.count++;
      System.out.println(prefix);
      return;
    }
    for (int i = 1; i <= n; i++) {
      String s = prefix == "" ? "" : "+";
      String newPrefix = prefix + s + i;
      countWays(newPrefix, n - i, count);
    }
  }

  private static void uniqueCountWays(String prefix, int n, int iterations, Count count) {
    if (n == 0) {
      count.count++;
      System.out.println(prefix);
      return;
    }
    for (int i = 1; i <= n && i <= iterations; i++) {
      String s = prefix == "" ? "" : "+";
      String newPrefix = prefix + s + i;
      uniqueCountWays(newPrefix, n - i, i, count);
    }
  }

  public static void main(String[] args) {
    Count count = new Count();
    countWays("", 5, count);
    System.out.println("Count : " + count.count);
    System.out.println();

    count = new Count();
    uniqueCountWays("", 5, 5, count);
    System.out.println("Unique Count : " + count.count);
  }
}
