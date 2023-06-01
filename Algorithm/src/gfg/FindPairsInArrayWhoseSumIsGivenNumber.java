package gfg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPairsInArrayWhoseSumIsGivenNumber {

    private static int[] a = {2, 4, 5, 1, 7, 8, 3, 6, 9, 0};
    private static int[] b = {8, 3, 6, 9, 0};
    private static int n = 5;

    private static void findPairs() {
        Set<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        for (int x : b) {
            if (set.contains(n - x)) {
                System.out.println(x + " " + (n - x));
            }
        }
    }

    public static void findPairs(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : nums) {
            int y = target - x;
            if (map.containsKey(y)) {
                if (x == y && map.get(x) == 1) {
                    continue;
                }
                System.out.println(x + "," + y);
                map.remove(x);
                map.remove(y);
            }
        }
    }

    public static void main(String[] args) {
        findPairs(new int[]{2, 6, 7, 1, 8, 3, 5, 5, 4, 5}, 10);
        System.out.println();
        findPairs(new int[]{0, 2, 2, 2}, 4);
    }
}
