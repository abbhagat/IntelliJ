package pairs;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayCanBeDivInPairsWithSumDivByK {

    private static boolean check(int[] a, int k) {
        if (a.length % 2 == 0) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : a) {
                int y = x % k;
                map.put(y, map.getOrDefault(y, 0) + 1);
            }
            for (int x : a) {
                int y = x % k;
                if (((y == 0 || y * 2 == k) && map.get(y) % 2 == 1) || map.get(y) != map.get(k - y)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{9, 7, 5, 3}, 6));
        System.out.println(check(new int[]{91, 74, 66, 48}, 10));
    }
}
