package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInAnArray {

    public static int[] arrayChange(int[] a, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }
        for (int[] operation : operations) {
            Integer index = map.get(operation[0]);
            if (index != null) {
                a[index] = operation[1];
                map.put(a[index], index);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[][] operations = {{1, 3}, {2, 1}, {3, 2}};
        for (int x : arrayChange(a, operations)) {
            System.out.println(x);
        }
    }
}
