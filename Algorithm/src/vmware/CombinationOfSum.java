package vmware;

import java.util.LinkedList;

// Time  Complexity O(n*2^n)
// Space Complexity O(n)
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

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 11};
        combinationForSum(0, 11, a, new LinkedList<>());
    }
}
