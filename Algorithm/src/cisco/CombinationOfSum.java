package cisco;

import java.util.Arrays;
import java.util.Collections;
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
            if(newTarget >= 0){
                list.add(a[i]);
                combinationForSum(i, newTarget, a, list);
                list.removeLast();
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        Arrays.sort(a);
        if(a == null || a.length == 0){
            System.out.println(Collections.emptyList());
        }
        combinationForSum(0, 7, a, new LinkedList<>());
    }
}
