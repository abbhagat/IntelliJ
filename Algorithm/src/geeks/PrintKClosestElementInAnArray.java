package geeks;

import java.util.stream.IntStream;

import static java.lang.Math.abs;

/*
Given a sorted array A[] and a value X, find the k closest elements to X in A[]

Input: K = 4, X = 35 and arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, only the other closest elements are required.
 */
// Time  Complexity: O(n)
// Space Complexity: O(1)
public class PrintKClosestElementInAnArray {

    private static void printKClosestElementInAnArray(int[] a, int n, int k) {
        int i = 0, j = a.length - 1;
        while (j - i >= k) {
            int x = abs(a[i] - n) > abs(a[j] - n) ? i++ : j--;
        }
        IntStream.range(i, j + 1).forEach(x -> System.out.print(a[x] + " "));  // Print array from i to j
    }

    public static void main(String[] args) {
        int[] a = new int[]{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        printKClosestElementInAnArray(a, 35, 4);
        System.out.println();
        printKClosestElementInAnArray(a, 22, 2);
        System.out.println();
        printKClosestElementInAnArray(a, 35, 3);
    }
}
