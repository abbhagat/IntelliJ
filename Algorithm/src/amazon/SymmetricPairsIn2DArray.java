package amazon;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class SymmetricPairsIn2DArray {

  private static void findSymmetricPairs(int[][] M) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] a : M) {
      int _1stVal = a[0];
      int _2ndVal = a[1];
      Integer val = map.get(_2ndVal);
      if (val != null && val == _1stVal) {
        System.out.println("(" + _1stVal + "," + _2ndVal + ")");
      }
      map.put(_1stVal, _2ndVal);
    }
  }

  public static void main(String[] args) {
    findSymmetricPairs(new int[][]{{1, 2}, {3, 4}, {4, 3}, {2, 1}, {5, 3}});
  }
}
