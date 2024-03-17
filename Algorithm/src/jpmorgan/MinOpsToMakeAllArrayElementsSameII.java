package microsoft;

/*
We are given an array consisting of n elements.
At each operation you can select any one element and increase rest of n-1 elements by 1.
You have to make all elements equal performing such operation as many times you wish.
Find the minimum number of operations needed for this.

Examples:

Input : a[] = {1, 2, 3}
Output : Minimum Operation = 3
Explanation :
operation | increased elements | after increment
    1     |    1, 2            | 2, 3, 3
    2     |    1, 2            | 3, 4, 3
    3     |    1, 3            | 4, 4, 4

Input : a[] = {4, 3, 4}
Output : Minimum Operation = 2
Explanation :
operation | increased elements | after increment
     1    |    1, 2           | 5, 4, 4
     2    |    2, 3           | 5, 5, 5
*/

import static java.lang.Integer.min;

public class MinOpsToMakeAllArrayElementsSameII {

    private static int printMinOp(int[] a) {
        int sum = 0, min = a[0];
        for (int x : a) {
            sum += x;
            min = min(min, x);
        }
        return sum - a.length * min;
    }

    public static void main(String[] args) {
        System.out.println(printMinOp(new int[]{1, 2, 3}));
        System.out.println(printMinOp(new int[]{4, 3, 4}));
        System.out.println(printMinOp(new int[]{5, 6, 2, 4, 3}));
        System.out.println(printMinOp(new int[]{5, 6, 2, 4, 3}));
    }
}
