package geeks;

import java.util.Arrays;
import java.util.LinkedList;

// Time Complexity: O(n*(2^n))

public class ArraySum {

    public static void combinationForSum(int[] a, int index, int givenSum, int curSum, LinkedList<Integer> list) {
        if (curSum == givenSum && !list.isEmpty()) {
            System.out.println(list);
        }
        if(curSum > givenSum) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            curSum += a[i];
            list.add(a[i]);
            combinationForSum(a, i + 1, givenSum, curSum, list);
            list.removeLast();
            curSum -= a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 15, -2, 2, -8, 1, 7, 10, 23};
        Arrays.sort(a);
        combinationForSum(a, 0, 0, 0, new LinkedList<>());
    }
}
