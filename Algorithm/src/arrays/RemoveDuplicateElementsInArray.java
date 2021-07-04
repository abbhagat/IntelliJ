package arrays;

/*
 * Soln 1 :  using nums hashmap
 * Soln 2 :  using nums BST
 * Soln 3 :  O(n^2)
 * Soln 4 :  using sorting
 *
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveDuplicateElementsInArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        Arrays.sort(nums);
        if (nums.length > 0) {
            int i, j = 0;
            for (i = 1; i < nums.length; i++) {
                if (nums[i - 1] != nums[i]) {
                    nums[j++] = nums[i - 1];
                }
            }
            i--;
            nums[j++] = nums[i];
            IntStream.range(0, j).forEach(k -> System.out.print(nums[k] + " "));
            System.out.println();
            System.out.println(j);
        } else {
            System.out.println(0);
        }

    }
}
