package geeks;

import java.util.*;

// Time Complexity: O(n*(2^n))
public class ArraySum {

    public static void combinationForSum(int[] a, int index, int currSum, int givenSum, LinkedList<Integer> list) {
        if (currSum == givenSum && !list.isEmpty()) {
            System.out.println(list);
            return;
        }
        if (currSum > givenSum) {
            return;
        }
        for (int i = index; i < a.length; i++) {
             currSum += a[i];
             list.add(a[i]);
             combinationForSum(a, i + 1, currSum, givenSum, list);
             list.removeLast();
             currSum -= a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 15, -2, 2, -8, 1, 7, 10, 23};
        Arrays.sort(a);
        combinationForSum(a, 0, 0, 0, new LinkedList<>());
    }
}
