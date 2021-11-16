package amazon;

import java.util.HashMap;
import java.util.Map;

public class SymmetricPairsIn2DArray {

    private static void findSymmetricPairs(int[][] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int _1stVal = a[i][0], _2ndVal = a[i][1];
            Integer val = map.get(_2ndVal);
            if (null != val && val == _1stVal) {
                System.out.println("(" + _1stVal + "," + _2ndVal + ")");
            }
            map.put(_1stVal, _2ndVal);
        }
    }

    public static void main(String[] args) {
        findSymmetricPairs(new int[][]{{1, 2}, {3, 4}, {4, 3}, {2, 1}, {5,3}});
    }
}
