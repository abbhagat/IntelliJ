package pairs;

import java.util.HashMap;
import java.util.Map;

/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9 Output: [0,1] Because nums[0] + nums[1] == 9, we return [0, 1].
Input: nums = [3,2,4],     target = 6 Output: [1,2]
Input: nums = [3,3],       target = 6 Output: [0,1]
*/

public class FindPairsIndexInArrayWhoseSumIsAGivenNumber {

    public static int[] twoSumIndex(int[] a, int target) {
        if (a == null || a.length < 2) {
            return new int[]{0, 0};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int y = target - a[i];
            if (map.containsKey(y)) {
                return new int[]{map.get(y), i};
            }
            map.put(a[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] index = twoSumIndex(new int[]{3, 2, 4}, 6);
        System.out.println(index[0] + "," + index[1]);
        index = twoSumIndex(new int[]{3, 3}, 6);
        System.out.println(index[0] + "," + index[1]);
    }
}
