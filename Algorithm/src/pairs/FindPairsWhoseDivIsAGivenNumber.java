package pairs;

import util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPairsWhoseDivIsAGivenNumber {

    private static Set<Pair> findPairs(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Pair> set = new HashSet<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        if (target == 0) {
            for (int x : a) {
                if (x != 0) {
                    set.add(new Pair(0, x));
                }
            }
            return set;
        }
        for (int x : a) {
            if (x % target == 0) {
                int y = x / target;
                if (map.containsKey(y)) {
                    if(map.get(y) == 1) {
                        continue;
                    }
                    set.add(new Pair(x, y));
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{5, 10, 5}, 1));
        System.out.println(findPairs(new int[]{12, 3, 6, 12, 8, 3, 24, 144, 0}, 0));
        System.out.println(findPairs(new int[]{12, 3, 6, 12, 8, 3, 24, 144, 1}, 12));
        System.out.println(findPairs(new int[]{12, 3, 6, 12, 8, 3, 24, 144, 1}, 12));
    }
}
