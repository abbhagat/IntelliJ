package adobe;

import java.util.HashSet;
import java.util.Set;

/*
  * Given an integer array nums and an integer k,
  * you are asked to construct the array A of size n-k+1 where A[i] is the number
  * of distinct numbers in the subarray nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]].
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

    public static int[] distinctNumbersBrute(int[] nums, int k) {
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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 1, 3};
        for (int x : distinctNumbersBrute(nums, 3)) {
            System.out.print(x + " ");
        }
    }
}
