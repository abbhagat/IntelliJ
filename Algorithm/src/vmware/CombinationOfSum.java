package vmware;

import java.util.Arrays;
import java.util.LinkedList;

// Time  Complexity : O(n * 2^n)
// Space Complexity : O(n)
public class CombinationOfSum {

    private static void combinationForSum(int index, int currSum, int givenSum, int[] a, LinkedList<Integer> list) {
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
            combinationForSum(i + 1, currSum, givenSum, a, list);
            list.removeLast();
            currSum -= a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 11};
        Arrays.sort(a);
        combinationForSum(0, 0, 11, a, new LinkedList<>());
    }
}
