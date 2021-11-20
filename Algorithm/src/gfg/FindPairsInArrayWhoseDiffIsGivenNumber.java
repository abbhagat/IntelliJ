package gfg;

import java.util.HashMap;
import java.util.Map;

public class FindPairsInArrayWhoseDiffIsGivenNumber {

    private static void findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x,0) + 1);
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
        System.out.println();
        findPairs(new int[]{10, 5, 15, 5, 0}, 5);
        System.out.println();
        findPairs(new int[]{10, 5, 15}, 5);
        System.out.println();
        findPairs(new int[]{10, 5, 15, 5, 0}, 0);
    }
}
