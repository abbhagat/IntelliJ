package geeks;

import java.util.stream.IntStream;

import static java.lang.Math.abs;

/*
Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]

Input: K = 4, X = 35 and arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, only the other closest elements are required.
 */
public class PrintKClosestElementInAnArray {

    private static void printKClosestElementInAnArray(int[] a, int n, int k) {
        int low = 0, high = a.length - 1;
        while (high - low >= k) {
            if (abs(a[low] - n) > abs(a[high] - n)) {
                low++;
            } else {
                high--;
            }
        }
        IntStream.range(low, high + 1).forEach(i -> System.out.print(a[i] + " "));
    }

    public static void main(String[] args) {
        int[] a = new int[]{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        printKClosestElementInAnArray(a, 35, 4);
        System.out.println();
        printKClosestElementInAnArray(a, 35, 2);
        System.out.println();
        printKClosestElementInAnArray(a, 35, 3);
    }
}
