package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void combinationForSum(int[] a, int index, int currSum, int givenSum, List<Integer> al, List<List<Integer>> list) {
        if (currSum == givenSum) {
            if (al.size() == 3 && !list.contains(al)) {
                list.add((new ArrayList<>(al)));
            }
        }
        if (currSum > givenSum) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            currSum += a[i];
            al.add(a[i]);
            combinationForSum(a, i + 1, currSum, givenSum, al, list);
            al.remove(al.size() - 1);
            currSum -= a[i];
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        combinationForSum(nums, 0, 0, 0, new ArrayList<>(), list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
