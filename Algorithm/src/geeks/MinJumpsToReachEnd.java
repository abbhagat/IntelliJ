package geeks;

/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element.
 * Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
 * If an element is 0, they cannot move through that element. If the end isn’t reachable, return -1.
 *
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 -> 9)
 * Explanation: Jump from 1st element to 2nd element as there is only 1 step, now there are three options 5, 8 or 9.
 * If 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.
 *
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
            min = result < min ? result : min;
        }
        return min + 1;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.print("Minimum number of jumps to reach end is " + minJumps(a, 0, a.length - 1));
    }
}
