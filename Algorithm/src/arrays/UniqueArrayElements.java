package arrays;

// Find the unique number that is present only once in an array while all the others are present three times.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueArrayElements {
    private static void printUniqueArrayElements(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(a).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        map.forEach((k, v) -> {
            if (v == 1 || v == 3) {
                System.out.println(k);
            }
        });
    }

    public static void main(String[] args) {
        printUniqueArrayElements(new int[]{2, 3, 5, 1, 2, 2, 5, 4, 3, 5, 3, 4, 2});
    }
}
