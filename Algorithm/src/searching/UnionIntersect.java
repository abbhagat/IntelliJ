package searching;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class UnionIntersect {

    private static void findUnionIntersection(int[] a, int [] b) {
        Map<Integer, Integer> map = new IdentityHashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : b) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        System.out.println("Intersection");
        map.forEach((k,v) -> {
            if(v > 1) {
                System.out.print(k + " ");
            }
        });
        System.out.println("\nUnion");
        System.out.println(map.keySet());
    }

    public static void main(String[] args) {
        int[] a = {12, 15, 30, 35, 46, 55, 60, 72, 89, 92, 100};
        int[] b = {12, 15, 300, 350, 46, 55, 60, 72, 89, 92, 100};
        Set<Integer> set = new HashSet<>();
        IntStream.range(0, a.length).forEach(i -> set.add(a[i]));
        System.out.println("Intersection");
        IntStream.range(0, b.length).forEach(i -> {
            if (!set.add(b[i])) {
                System.out.print(b[i] + " ");
            }
        });
        System.out.println("\nUnion");
        System.out.print(set);
        System.out.println();
        findUnionIntersection(a, b);
    }
}
