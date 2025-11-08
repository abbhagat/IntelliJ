package geeks;

import java.util.*;

// Time  Complexity : O(n*2^n)
// Space Complexity : O(n)
public class MaxArrayGivenSum {

    public static void combinationForSum(int[] a, int index, List<Integer> al, int givenSum, int curSum, Set<List<Integer>> list) {
        if (curSum == givenSum && !al.isEmpty()) {
            list.add(new ArrayList<>(al));
            return;
        }
        if (curSum > givenSum) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            curSum += a[i];
            al.add(a[i]);
            combinationForSum(a, i + 1, al, givenSum, curSum, list);
            al.remove(al.size() - 1);
            curSum -= a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(a);
        Set<List<Integer>> list = new HashSet<>();
        combinationForSum(a, 0, new ArrayList<>(), 0, 0, list);
        System.out.println(list);
    }
}
