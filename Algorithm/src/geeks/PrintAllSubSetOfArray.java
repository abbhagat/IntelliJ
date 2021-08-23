package geeks;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: array = {1, 2, 3}
 * Output: // this space denotes null element.
 * 1
 * 1 2
 * 1 2 3
 * 1 3
 * 2
 * 2 3
 * 3
 * Explanation: These are all the subsets that
 * can be formed using the array.
 * <p>
 * Input: 1 2
 * Output:
 * 1
 * 2
 * 1 2
 * Explanation: These are all the subsets that
 * can be formed using the array.
 */

public class PrintAllSubSetOfArray {

    public static void main(String[] args) {
        findSubSet(new int[]{1, 2, 3}, 0, new ArrayList<>());
    }

    /*Recursively traverse the array, there are two situations for each element:
      1. Select the element
      2. Not select the element
      */

    public static void findSubSet(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {                      //All elements have been traversed
            if (!list.isEmpty()) {
                System.out.println(list);
            }
            return;
        }
        findSubSet(nums, index + 1, list);   // Do not select the current index element
        list.add(nums[index]);                    // Select the current index element
        findSubSet(nums, index + 1, list);  // Unselect the current index element (backtracking)
        list.remove(list.size() - 1);
    }
}
