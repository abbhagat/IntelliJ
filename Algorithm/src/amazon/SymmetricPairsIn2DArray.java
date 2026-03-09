package amazon;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class SymmetricPairsIn2DArray {

  private static void findSymmetricPairs(int[][] M) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] a : M) {
      int x = a[0];
      int y = a[1];
      Integer val = map.get(y);
      if (val != null && val == x) {
        System.out.println("(" + x + "," + y + ")");
      }
      map.put(x, y);
    }
  }

  public static void main(String[] args) {
    findSymmetricPairs(new int[][]{{1, 2}, {3, 4}, {4, 3}, {2, 1}, {5, 3}});
  }
}
