package geeksforgeeks;

/*
Given an integer array a, move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

Input: a = [0,1,0,3,12]
Output: [1,3,12,0,0]
Input: a = [0]
Output: [0]
 */

import java.util.stream.IntStream;

public class MoveZeroesToEnd {

    private static void moveZeroesToEnd(int[] a) {
        int i = 0, j = 0;
        while (i < a.length) {
            if (a[i] == 0) {
                i++;
            } else {
                a[j++] = a[i++];
            }
        }
        IntStream.range(j, a.length).forEach(k -> a[k] = 0);
        IntStream.range(0, a.length).forEach(k -> System.out.print(a[k] + " "));
    }

    public static void main(String[] args) {
        moveZeroesToEnd(new int[]{0, 1, 0, 3, 12});
    }
}
