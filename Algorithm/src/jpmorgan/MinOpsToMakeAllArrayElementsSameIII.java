package microsoft;

/*
Given an array containing N elements and an integer K. It is allowed to perform the following operation any number of times on the given array:
Insert the K-th element at the end of the array and delete the first element of the array.
The task is to find the minimum number of moves needed to make all elements of the array equal.
Print -1 if it is not possible.
Input : a[] = {1, 2, 3, 4}, K = 4
Output : 3
Step 1: 2 3 4 4
Step 2: 3 4 4 4
Step 3: 4 4 4 4

Input : a[] = {2, 1}, K = 1
Output : -1
The array will keep alternating between 1, 2 and 2, 1 regardless of how many moves you apply.
*/

public class MinOpsToMakeAllArrayElementsSameIII {

    private static int countMinimumMoves(int[] a, int k) {
        int n = a[k - 1];
        for (int i = k - 1; i < a.length; i++) {
            if (a[i] != n) {
                return -1;
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            if (a[i] != n) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countMinimumMoves(new int[]{1, 2, 3, 4}, 4));
        System.out.println(countMinimumMoves(new int[]{2, 1}, 1));
    }
}
