package geeks;

import java.util.HashMap;
import java.util.Map;

public class ArrayUnionIntersection {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int a[] = {12, 55, 60, 72, 89, 35, 35, 46, 12, 46, 100};
        int b[] = {12, 15, 30, 23, 10, 60, 35, 89, 92, 100, 10, 23, 45, 60};
        for (int x : a) {
            map.put(x, 1);
        }
        System.out.println("Array Intersection");
        for (int x : b) {
            if (map.containsKey(x)) {
                System.out.print(x + " ");
            } else {
                map.put(x, 1);
            }
        }
        System.out.println("\nArray Union");
        map.keySet().forEach(key -> System.out.print(key + " "));
    }
}
