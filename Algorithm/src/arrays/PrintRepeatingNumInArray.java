package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
Soln 1: using a hashmap
Soln 2: using a BST
Soln 3: O(n^2)
 */

public class PrintRepeatingNumInArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 100, 3, 6, 6, 4, 5, 3, 5, 4, 3};
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> m : set) {
            if (m.getValue() > 1) {
                System.out.print(m.getKey() + " ");
            }
        }
    }
}
