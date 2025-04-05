package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// Time Complexity  O(2^n)
// Space Complexity O(n)
public class _3Sum {

    private static Set<LinkedList<Integer>> combinationForSum(int index, int curSum, int givenSum, int[] a, LinkedList<Integer> list, Set<LinkedList<Integer>> set) {
        if (curSum == givenSum && list.size() == 3) {
            set.add(new LinkedList<>(list));
        }
        for (int i = index; i < a.length; i++) {
            curSum += a[i];
            list.add(a[i]);
            combinationForSum(i + 1, curSum, givenSum, a, list, set);
            list.removeLast();
            curSum -= a[i];
        }
        return set;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(a);
        System.out.println(combinationForSum(0, 0,  0, a, new LinkedList<>(), new HashSet<>()));
        System.out.println(combinationForSum(0, 0, -1, a, new LinkedList<>(), new HashSet<>()));
    }
}
