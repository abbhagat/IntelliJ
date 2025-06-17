package pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Time  Complexity: O(n)
// Space Complexity: O(n)
public class FindPairsInArrayWhoseProductIsGivenNumber {

    private static void findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(a).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        for (int x : a) {
            int y = target / x;
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
        int[] a = new int[]{12, 3, 6, 2, 12, 8, 3, 4, 144, 1};
        findPairs(a, 12);
        System.out.println();
        findPairs(a, 24);
        System.out.println();
        findPairs(a, 144);
    }
}
