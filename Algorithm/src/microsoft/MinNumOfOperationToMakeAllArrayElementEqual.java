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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.min;

public class MinNumOfOperationToMakeAllArrayElementEqual {

    private static int printMinOp(int[] a) {
        int sum = 0, min = a[0];
        for (int x : a) {
            sum += x;
            min = min(min, x);
        }
        return sum - a.length * min;
    }

    private static int printMinOps(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        int max = list.get(0).getKey();
        return Math.abs(max - a.length);
    }

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

    private static int minimumChangesToMakeAllArrayElementsToZero(int[] a) {
        int i, change = 0;
        for (i = 0; i + 1 < a.length; i++) {
            if (a[i] == 1 && a[i + 1] == 0) {
                change++;
            }
        }
        if (a[a.length - 1] == 1) {
            change++;
        }
        return change;
    }

    public static void main(String[] args) {
        System.out.println(printMinOp(new int[]{1, 2, 3}));
        System.out.println(printMinOp(new int[]{4, 3, 4}));
        System.out.println(printMinOp(new int[]{5, 6, 2, 4, 3}));
        System.out.println(printMinOp(new int[]{5, 6, 2, 4, 3}));
        System.out.println();
        System.out.println(printMinOps(new int[]{1, 2, 3, 4}));
        System.out.println();
        System.out.println(countMinimumMoves(new int[]{1, 2, 3, 4}, 4));
        System.out.println(countMinimumMoves(new int[]{2, 1}, 1));

        System.out.println(minimumChangesToMakeAllArrayElementsToZero(new int[]{1, 1, 0, 0, 0, 1, 0, 1, 1}));
        System.out.println(minimumChangesToMakeAllArrayElementsToZero(new int[]{1, 1, 1, 1}));
    }
}
