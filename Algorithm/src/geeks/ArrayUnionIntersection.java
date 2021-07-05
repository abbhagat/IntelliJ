package geeks;

import java.util.HashMap;
import java.util.Map;

public class ArrayUnionIntersection {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int a[] = {12, 55, 60, 72, 89, 35, 35, 46, 12, 46, 100};
        int b[] = {12, 15, 30, 23, 10, 60, 35, 89, 92, 100, 10, 23, 45, 60};
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], 1);
        }
        System.out.println("Array Intersection");
        for (int i = 0; i < a.length; i++) {
            if (map.get(a[i]) != null) {
                System.out.print(a[i] + " ");
            }else{
                map.put(a[i], 1);
            }
        }
        System.out.println("\nArray Union");
        map.keySet().forEach(System.out::print);
    }
}
