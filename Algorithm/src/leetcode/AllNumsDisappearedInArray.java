package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AllNumsDisappearedInArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int x : map.values()) {
            sum += x;
        }
        int i;
        for (i = 1; i < nums.length; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }
        if (i <= sum && !map.containsKey(i)) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDisappearedNumbers(new int[]{1, 1}));
    }
}
