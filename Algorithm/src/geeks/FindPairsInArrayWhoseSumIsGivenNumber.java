package geeks;

import java.util.HashMap;
import java.util.Map;

public class FindPairsInArrayWhoseSumIsGivenNumber {

    private static int[] a = {2, 4, 5, 1, 7, 8, 3, 6, 9, 0};
    private static int[] b = {8, 3, 6, 9, 0};
    private static int n = 5;

    private static void findPairs() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, 1);
        }
        for (int x : b) {
            if (map.containsKey(n - x)) {
                System.out.println(x + " " + (n - x));
            }
        }
    }

    public static void findPairs(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer k = map.get(x) == null ? map.put(x, 1) : map.put(x, map.get(x) + 1);
        }
        for (int x : nums) {
            int y = target - x;
            if ((x == y && map.containsKey(y) && map.get(y) == 1)) {
                continue;
            }
            if (map.containsKey(y)) {
                System.out.println(x + "\t" + y);
                map.remove(x);
                map.remove(y);
            }
        }
    }

    public static void main(String[] args) {
        findPairs();
    }
}
