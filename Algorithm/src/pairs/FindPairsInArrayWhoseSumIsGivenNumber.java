package pairs;

import java.util.HashMap;
import java.util.Map;

public class FindPairsInArrayWhoseSumIsGivenNumber {
    public static void findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : a) {
            int y = target - x;
            if (map.containsKey(y)) {
                if (x == y && map.get(y) == 1) {
                    continue;
                }
                System.out.println(x + "," + y);
                map.remove(x);
                map.remove(y);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        findPairs(new int[]{2, 6, 7, 1, 8, 3, 5, 5, 4, 5}, 10);
        findPairs(new int[]{0, 2, 2, 2}, 4);
    }
}
