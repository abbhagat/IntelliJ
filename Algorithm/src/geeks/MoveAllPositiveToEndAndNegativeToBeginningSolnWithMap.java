package geeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class MoveAllPositiveToEndAndNegativeToBeginningSolnWithMap {

    private static int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
    private static Map<Integer, Integer> map = new HashMap<>();

    private static void move() {
        for (int x : a) {
            Integer k = x < 0 ? map.put(x, -1) : map.put(x, 1);
        }
        int i = 0, j = a.length - 1;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> map : set) {
            if (map.getValue() > 0) {
                a[j--] = map.getKey();
            } else {
                a[i++] = map.getKey();
            }
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        move();
        System.out.println();
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
