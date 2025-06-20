package pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairsInArrayWhoseSumIsGivenNumber {

    public static void findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(a).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        for (int x : a) {
            int y = target - x;
            if (map.containsKey(y)) {
                if (x == y && map.get(y) == 1) {
                    continue;
                }
                System.out.println("(" + x + "," + y + ")");
                if (x != y) {
                    System.out.println("(" + y + "," + x + ")");
                }
                map.remove(x);
                map.remove(y);
            }
        }
    }

    public static void main(String[] args) {
        findPairs(new int[]{1, 2, 3, 4, 5}, 5);
        System.out.println();
        findPairs(new int[]{2, -3, 3, 3, -2}, 0);
        System.out.println();
        findPairs(new int[]{2, -6, 2, 5, 2}, 4);
    }
}
