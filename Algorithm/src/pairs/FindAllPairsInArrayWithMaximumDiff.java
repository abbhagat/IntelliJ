package pairs;

import java.util.Arrays;

// Time  Complexity : O(n log n)
// Space Complexity : O(1)
public class FindAllPairsInArrayWithMaximumDiff {

  private static void findPairs(int[] a) {
    Arrays.sort(a);
    System.out.println(a[a.length - 1] + "," + a[0]);
  }

  public static void main(String[] args) {
    findPairs(new int[]{6, 2, 4, 10});
    System.out.println("---");
    findPairs(new int[]{5, 4, 3, 2});
    System.out.println("---");
    findPairs(new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854});
    System.out.println("---");
    findPairs(new int[]{1, 2, 3, 4});
    System.out.println("---");
    findPairs(new int[]{1, 1, 2, 1, 2, 3});
    System.out.println("---");
    findPairs(new int[]{1, 7, 11, 2, 4, 6});
  }
}
