package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class _3Sum {

    private static void combinationForSum(int index, int curSum, int givenSum, int[] a, LinkedList<Integer> list) {
        if (curSum == givenSum && list.size() == 3) {
            System.out.println(list);
            return;
        }
        if (curSum > givenSum) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            curSum += a[i];
            list.add(a[i]);
            combinationForSum(i + 1, curSum, givenSum, a, list);
            list.removeLast();
            curSum -= a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(a);
        combinationForSum(0, 0, 0, a, new LinkedList<>());
    }
}
