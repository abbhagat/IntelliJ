package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxArrayGivenSum {

    public static void combinationForSum(int[] a, int index, List<Integer> al, int givenSum, int curSum) {

        if (curSum == givenSum) {
            System.out.println(Arrays.toString(al.toArray()));
        }

        if (curSum > givenSum) {
            return;
        }

        for (int i = index; i < a.length; i++) {
            curSum += a[i];
            al.add(a[i]);
            combinationForSum(a, i + 1, al, givenSum, curSum);
            al.remove(al.size() - 1);
            curSum -= a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 15, -2, 2, -8, 1, 7, 10, 23};
        int givenSum = 10;
        int curSum = 0;
        combinationForSum(a, 0, new ArrayList<>(), givenSum, curSum);
    }
}
