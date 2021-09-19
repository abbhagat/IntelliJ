package cisco;

import java.util.HashMap;
import java.util.Map;

public class FindPairsInArrayWhoseProductIsGivenNumber {

    private static int countUniquePairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            Integer k = map.get(x) == null ? map.put(x, 1) : map.put(x, map.get(x) + 1);
        }
        int count = 0;
        for (int x : a) {
            int y = target / x;
            if (map.containsKey(y)) {
                if ((x == y && map.get(x) == 1)) {
                    continue;
                }
                System.out.println("(" + x + "," + y + ")");
                map.remove(x);
                map.remove(y);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 3, 6, 12, 8, 3, 4, 144, 1};
        int target = 144;
        System.out.println(countUniquePairs(nums, target));
    }
}
