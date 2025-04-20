package adobe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static util.CommonUtils.printArray;

/*
  * Given an integer array nums and an integer k,
  * you are asked to construct the array A of size n-k+1 where A[i] is the number
  * of distinct numbers in the subarray nums[i: i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]].
  *
  *  Input: nums = [1,2,3,2,2,1,3], k = 3
  Output: [3,2,2,2,3]
  Explanation: The number of distinct elements in each subarray goes as follows:
  - nums[0:2] = [1,2,3] so ans[0] = 3
  - nums[1:3] = [2,3,2] so ans[1] = 2
  - nums[2:4] = [3,2,2] so ans[2] = 2
  - nums[3:5] = [2,2,1] so ans[3] = 2
  - nums[4:6] = [2,1,3] so ans[4] = 3
*/


public class ArrayUniqueCountInSubset {
    // Time  Complexity: O(n * k)
   //  Space Complexity: O(k)
    public static int[] distinctNumbers1(int[] nums, int k) {
        int n = nums.length - k + 1;
        int[] a = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < nums.length && j < k + i; j++) {
                set.add(nums[j]);
            }
            a[i] = set.size();
            set.clear();
        }
        return a;
    }

     // Time  Complexity: O(n)
    //  Space Complexity: O(k)
    public static int[] distinctNumbers2(int[] a, int k) {
        int n = a.length - k + 1;
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        res[0] = map.size();
        // Slide the window
        for (int i = 1; i < n; i++) {
            int x = a[i - 1];         // Remove the element going out of the window
            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) {
                map.remove(x);
            }
            int y = a[i + k - 1];   // Add the new element coming into the window
            map.put(y, map.getOrDefault(y, 0) + 1);
            res[i] = map.size();  // Store the size of the map as the count of distinct elements
        }
        return res;
    }

    public static void main(String[] args) {
        printArray(distinctNumbers1(new int[] {1, 2, 3, 2, 2, 1, 3}, 3));
        printArray(distinctNumbers2(new int[] {1, 2, 3, 2, 2, 1, 3}, 3));
    }
}
