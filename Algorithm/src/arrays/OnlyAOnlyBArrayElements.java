package arrays;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlyAOnlyBArrayElements {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int[] b = { 1, 2, 3, 4, 5, 7, 9, 11, 13, 15, 17, 19 };

        Map<Integer, Integer> chm = new ConcurrentHashMap<>();
        for (int x : a) {
            chm.put(x, 1);
        }
        for (int x : b) {
            if (chm.get(x) == null) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
        for (int x : b) {
            if (chm.get(x) != null) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }
}
