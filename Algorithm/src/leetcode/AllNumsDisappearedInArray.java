package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class AllNumsDisappearedInArray {

    public static void findDisappearedNumbers(int[] a) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int sum = 0;  // map.values().stream().reduce(0, (x,y) -> x + y) OR map.values().stream().reduce(0, Integer::sum);
        for (int x : map.values()) {
            sum += x;
        }
        for (int i = 1; i < a.length || i <= sum; i++) {
            if (map.get(i) == null) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        findDisappearedNumbers(new int[]{1, 1});
    }
}
