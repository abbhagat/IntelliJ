package geeks;

/*
Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]

Input: K = 4, X = 35 and arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, only the other closest elements are required.
 */
public class PrintKClosestElementInAnArray {

    private static int binarySearch(int[] a, int low, int high, int n) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == n) {
                return mid;
            }
            return n < a[mid] ? binarySearch(a, low, mid - 1, n) : binarySearch(a, mid + 1, high, n);
        }
        return -1;
    }

    private static void printKClosestElementInAnArray(int[] a, int n, int k) {
        int left = binarySearch(a, 0, a.length - 1, n);
        int right, count = 0;
        right = left + 1;
        left = left - 1;
        while (left >= 0 && right < a.length && count < k) {
            System.out.println(n - a[left] < a[right] - n ? a[left--] : a[right++]);
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
