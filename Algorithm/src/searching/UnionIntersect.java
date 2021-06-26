package searching;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UnionIntersect {

    public static void main(String[] args) {

        int[] a = {12, 15, 30, 35, 46, 55, 60, 72, 89, 92, 100};
        int[] b = {12, 15, 300, 350, 46, 55, 60, 72, 89, 92, 100};
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            if (map.get(x) == null) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x) + 1);
            }
        }
        for (int x : b) {
            if (map.get(x) == null) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x) + 1);
            }
        }
        System.out.println("Union");
        map.keySet().forEach(key -> System.out.print(key + " "));
        System.out.println();
        System.out.println("Intersection");
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> m : set) {
            if (m.getValue() > 1) {
                System.out.print(m.getKey() + " ");
            }
        }
    }

}
