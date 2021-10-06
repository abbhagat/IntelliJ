package gfg;

import java.util.HashMap;
import java.util.Map;

public class FindPairsInArrayWhoseDiffIsGivenNumber {

    private static void findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            Integer k = map.containsKey(x) ? map.put(x, map.get(x) + 1) : map.put(x, 1);
        }
        for (int x : a) {
            int y = x - target;
            if (map.containsKey(y)) {
                if (x == y && map.get(x) == 1) {
                    continue;
                }
                System.out.println("(" + x + "," + y + ")");
                map.remove(x);
                map.remove(y);
            }
        }
    }

    public static void main(String[] args) {
        findPairs(new int[]{2, 6, 7, 1, 8, 3, 5, 5, 4, 5}, 4);
    }
}
