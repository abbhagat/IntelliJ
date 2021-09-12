package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _4Sum {

    private static Map<Integer, List<Integer>> map = new HashMap<>();

    private static void fourSum(int index, int curSum, int givenSum, int[] a, LinkedList<Integer> list) {
        if (curSum == givenSum && list.size() == 4) {
            System.out.println(list);
            return;
        }
        if (curSum > givenSum) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            curSum += a[i];
            list.add(a[i]);
            fourSum(index + 1, curSum, givenSum, a, list);
            list.removeLast();
            curSum -= a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2};
        fourSum(0, 0, 0, a, new LinkedList<>());
        System.out.println(map);
    }
}
