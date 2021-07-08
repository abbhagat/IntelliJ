package leetcode;

import java.util.stream.IntStream;

public class RemoveAGivenRepeatedElementFromArray {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int n = nums.length;
        for (int i = 0; i < n;) {
            if (nums[i] == val) {
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                n--;
            }else{
                i++;
            }
        }
        IntStream.range(0, n).forEach(i -> System.out.print(nums[i] + " "));
    }
}
