package oracle;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateElementsInAnArray {

    private static void removeDuplicates(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(a).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        System.out.println(set + "\n" + map.keySet());
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 7, 1, 6, 8, 9, 10, 30, 6, 3, 5, 10, 20, 4, 9, 10, 1, 30};
        removeDuplicates(a);
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] != a[i]) {
                System.out.print(a[i - 1] + " ");
            }
        }
        System.out.println(a[a.length - 1]);
    }
}
