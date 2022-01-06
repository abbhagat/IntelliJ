package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

// Time Complexity O(n*2^n) + O(nlog(n))
public class _4Sum {

    private static void combinationForSum(int index, int curSum, int givenSum, int[] a, LinkedList<Integer> list) {
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
            combinationForSum(i + 1, curSum, givenSum, a, list);
            list.removeLast();
            curSum -= a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2};
        Arrays.sort(a);
        combinationForSum(0, 0, 0, a, new LinkedList<>());
    }
}
