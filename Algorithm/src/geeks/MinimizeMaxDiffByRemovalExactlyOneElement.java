package geeks;

import java.util.Arrays;

import static java.lang.Integer.min;

/**
 * Given an array arr[] consisting of N integers(N > 2), the task is to minimize the maximum difference between any pair of elements
 * (arr[i], arr[j]) by removing exactly one element.
 * Examples:
    <p>
    Input: arr[] = {1, 3, 4, 7}
    Output: 3
    Explanation:
    Removing the element 7 from array, modifies the array  to {1, 3, 4}.
    Here (4, 1) has difference = 4 – 1 = 3 which is minimum possible maximum difference.
    Input: arr[] = {1, 2, 3, 4}
    Output: 2
    Naive Approach: The simplest approach to solve the given problem is to remove every element one by one and check which element
    gives the minimized maximum difference between every pair of elements.
    Time Complexity: O(N3)
    Auxiliary Space: O(N)
    <p>
    Efficient Approach: The above approach can also be optimized by observing the fact that the maximum difference
    is equal to the difference between the maximum and the minimum element of the given array.
    So, removing the maximum element or removing the minimum element always gives the optimal answer.
    Time Complexity: O(N*log N)
    Auxiliary Space: O(N)
    Therefore, the idea is to sort the given array in ascending order and print the minimum of the value
    (arr[N – 2] – arr[0]) and (arr[N – 1] – arr[1]) as the resultant minimized maximum difference.
 */
public class MinimizeMaxDiffByRemovalExactlyOneElement {

    private static int findMinDifference(int[] a) {
        Arrays.sort(a);
        return min(a[a.length - 2] - a[0], a[a.length - 1] - a[1]);
    }

    public static void main(String[] args) {
        System.out.println(findMinDifference(new int[]{-1, 3, 4, 7}));
    }

}
