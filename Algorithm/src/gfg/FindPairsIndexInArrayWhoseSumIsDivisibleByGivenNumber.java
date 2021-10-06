package gfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Input: nums = [3,2,4], target = 6
Output: [1,2]
Input: nums = [3,3], target = 6
Output: [0,1]
 */

public class FindPairsIndexInArrayWhoseSumIsDivisibleByGivenNumber {

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.containsKey(nums[i]) ? map.get(nums[i]) : new ArrayList();
            list.add(i);
            map.put(nums[i], list);
        }
        int[] K = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - x;
            if ((x == y && map.get(y).size() >= 2)) {
                K[0] = map.get(x).get(0);
                K[1] = map.get(y).get(1);
                break;
            }
            if (map.containsKey(y)) {
                K[0] = map.get(x).get(0);
                K[1] = map.get(y).get(0);
                break;
            }
        }
        return K;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 7, 1, 8, 3, 5, 5, 5, 5};
        int target = 10;
        for (int x : twoSum(nums, target)) {
            System.out.println(x);
        }
    }
}
