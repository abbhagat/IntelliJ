package geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxArrayGivenSum {

    private static List<List<Integer>> list = new ArrayList<>();

    public static void combinationForSum(int[] a, int index, List<Integer> al, int givenSum, int curSum) {

        if (curSum == givenSum && !list.contains(al)) {
            list.add(new ArrayList<>(al));
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
        int[] a = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(a);
        int givenSum = 0;
        int curSum = 0;
        combinationForSum(a, 0, new ArrayList<>(), givenSum, curSum);
        System.out.println(list);
    }
}
