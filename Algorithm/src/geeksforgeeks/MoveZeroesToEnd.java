package geeksforgeeks;

import java.util.Arrays;
import java.util.stream.IntStream;
/**
Given an int[] a move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Input: a = [0,1,0,3,12] Output: [1,3,12,0,0]
Input: a = [0] Output: [0]
*/

public class MoveZeroesToEnd {

    private static void moveZeroesToEnd(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[j] = a[i];
                j++;
            }
        }
        IntStream.range(j, a.length).forEach(i -> a[i] = 0);
        Arrays.stream(a).forEach(i -> System.out.print(a[i] + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        moveZeroesToEnd(new int[]{0});
        moveZeroesToEnd(new int[]{0, 1, 0, 3, 12});
        moveZeroesToEnd(new int[]{0, 1, 0, 0, 3, 4, 12, 0, 0, 0});
    }
}
