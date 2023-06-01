package geeksforgeeks;

import java.util.*;

public class ThreeSum {

    public static void combinationForSum(int[] a, int index, int currSum, int givenSum, List<Integer> list, Set<List<Integer>> set) {
        if (currSum == givenSum && list.size() == 3) {
            set.add((new ArrayList<>(list)));
        }
        if (currSum > givenSum) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            currSum += a[i];
            list.add(a[i]);
            combinationForSum(a, i + 1, currSum, givenSum, list, set);
            list.remove(list.size() - 1);
            currSum -= a[i];
        }
    }

    public static Set<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        combinationForSum(nums, 0, 0, 0, new ArrayList<>(), set);
        return set;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
