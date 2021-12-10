package geeks;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element.
 * Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
 * If an element is 0, they cannot move through that element. If the end isn’t reachable, return -1.
 * <p>
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 -> 9)
 * Explanation: Jump from 1st element to 2nd element as there is only 1 step, now there are three options 5, 8 or 9.
 * If 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.
 * <p>
 * Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
 * Output: 10
 * Explanation: In every step a jump is needed so the count of jumps is 10.
 */
public class MinJumpsToReachEnd {

    private static int minJumps(int a[], int l, int h) {
        if (l == h) {   // Base case: when source and destination are same
            return 0;
        }
        if (a[l] == 0) {   // When nothing is reachable from the given source
            return -1;
        }
        // Traverse through all the points reachable from array. Recursively get the minimum number of jumps needed to reach arr[h] from these reachable points.
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + a[l]; i++) {
            int result = minJumps(a, i, h);
            min = min(min, result);
        }
        return min + 1;
    }

    private static int minJumps(int[] a) {
        int steps = 0, current = 0, last = 0;
        for (int i = 0; i < a.length; i++) {
            if (i > last) {
                last = current;
                steps++;
                if (last >= a.length) {
                    return steps;
                }
            }
            current = max(current, i + a[i]);
        }
        return steps;
    }

    private static boolean isReachable(int[] a) {
        int last = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (i + a[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Min jumps to reach end " + minJumps(a, 0, a.length - 1));
        System.out.println("Min jumps to reach end " + isReachable(a));
        System.out.println("Min jumps to reach end " + minJumps(a));
        System.out.println();
        int b[] = {2, 3, 1, 1, 4};
        System.out.println("Min jumps to reach end " + minJumps(b, 0, b.length - 1));
        System.out.println("Min jumps to reach end " + isReachable(b));
        System.out.println("Min jumps to reach end " + minJumps(b));
    }
}
