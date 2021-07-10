package leetcode;

/*
Given an integer array nums, move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Input: nums = [0]
Output: [0]
 */


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        List<Integer> zeroPositions = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                zeroPositions.add(i);
            }
        }
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (!zeroPositions.contains(i)) {
                a[j] = a[i];
                j++;
            }
        }
        for (int i = j; i < a.length; i++) {
            a[i] = 0;
        }
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
