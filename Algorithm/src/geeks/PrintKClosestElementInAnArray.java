package geeks;

import static java.lang.Math.abs;

/*
Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]

Input: K = 4, X = 35 and arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, only the other closest elements are required.
 */
public class PrintKClosestElementInAnArray {

    private static void printKClosestElementInAnArray(int[] a, int n, int k) {
        int mid = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                mid = i;
            }
        }
        int count = 0, left = mid - 1, right = mid + 1;
        while (left >= 0 && right < a.length && count < k) {
            System.out.println(abs(n - a[left]) < abs(n - a[right]) ? a[left--] : a[right++]);
            count++;
        }
        while (left >= 0 && right == a.length - 1 && count < k) {
            System.out.println(a[left--]);
            count++;
        }
        while (left == 0 && right < a.length - 1 && count < k) {
            System.out.println(a[right++]);
            count++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        printKClosestElementInAnArray(a, 35, 4);
    }
}
