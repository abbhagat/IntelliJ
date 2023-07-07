package amazon;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity  O(n)
// Space Complexity  O(n)

public class SymmetricPairsIn2DArray {

    private static void findSymmetricPairs(int[][] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] x : a) {
            int _1stVal = x[0];
            int _2ndVal = x[1];
            Integer val = map.get(_2ndVal);
            if (null != val && val == _1stVal) {
                System.out.println("(" + _1stVal + "," + _2ndVal + ")");
            }
            map.put(_1stVal, _2ndVal);
        }
    }

    public static void main(String[] args) {
        findSymmetricPairs(new int[][]{{1, 2}, {3, 4}, {4, 3}, {2, 1}, {5, 3}});
    }
}
