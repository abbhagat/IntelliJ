package pairs;

import java.util.HashMap;
import java.util.Map;

public class FindPairsInArrayWhoseProductIsGivenNumber {

    private static void findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : a) {
            int y = target / x;
            if (map.containsKey(y)) {
                if (x == y && map.get(y) == 1) {
                    continue;
                }
                if (x == y) {
                    System.out.println("(" + x + "," + y + ")");
                } else {
                    System.out.println("(" + x + "," + y + ")");
                    System.out.println("(" + y + "," + x + ")");
                }
                map.remove(x);
                map.remove(y);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{12, 3, 6, 2, 12, 8, 3, 4, 144, 1};
        findPairs(a, 12);
        findPairs(a, 24);
        findPairs(a, 144);
    }
}
