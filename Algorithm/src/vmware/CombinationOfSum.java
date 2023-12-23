package vmware;

import java.util.Arrays;
import java.util.LinkedList;

// Time Complexity O(n*2^n) + O(nlog(n))
public class CombinationOfSum {

    private static void combinationForSum(int index, int givenSum, int[] a, LinkedList<Integer> list) {
        if (givenSum == 0) {
            System.out.println(list);
            return;
        }
        for (int i = index; i < a.length; i++) {
            int newTarget = givenSum - a[i];
            if (newTarget >= 0) {
                list.add(a[i]);
                combinationForSum(i, newTarget, a, list);
                list.removeLast();
            } else {
                break;
            }
        }
    }

    private static void combinationForSum(int index, int currSum, int givenSum, int[] a, LinkedList<Integer> list) {
        if (currSum == givenSum) {
            System.out.println(list);
            return;
        }
        if (currSum > givenSum) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            currSum += a[i];
            list.add(a[i]);
            combinationForSum(i, currSum, givenSum, a, list);
            currSum -= a[i];
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 11};
        Arrays.sort(a);
        combinationForSum(0, 11, a, new LinkedList<>());
        combinationForSum(0, 0, 11, a, new LinkedList<>());
    }
}
