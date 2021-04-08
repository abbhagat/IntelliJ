package arrays;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Soln 1 :  using a hashmap
 * Soln 2 :  using a BST
 * Soln 3 : O(n^2)
 *
 */

public class PrintRepeatingNumInArray {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 100, 3, 6, 6, 4, 5, 3, 5, 4, 3 };
        Map<String, Integer> chm = new ConcurrentHashMap<>();
        for (int x : a) {
            if (chm.get(Integer.toString(x)) == null) {
                chm.put(Integer.toString(x), 1);
            } else {
                chm.put(Integer.toString(x), chm.get(Integer.toString(x)) + 1);
            }
        }
        Set<Map.Entry<String, Integer>> set = chm.entrySet();
        for (Map.Entry<String, Integer> m : set) {
            if (m.getValue() > 1) {
                System.out.print(m.getKey() + " ");
            }
        }
    }
}
