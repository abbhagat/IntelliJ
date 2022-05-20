package leetcode;

public class CheckIfAnArrayRepresentsMaxHeap {

    private static boolean isMaxHeap(int[] a, int i, int n) {
        if (i >= (n - 2) / 2) {
            return true;
        }
        int left  = 2 * i + 1;
        int right = 2 * i + 2;
        if (a[i] >= a[left] && a[i] >= a[right] && isMaxHeap(a, left, n) && isMaxHeap(a, right, n)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {90, 15, 10, 7, 12, 2, 7, 3};
        int[] b = {10, 50, 80, 55, 57, 85, 90};
        System.out.println(isMaxHeap(a, 0, a.length - 1) ? "Yes" : "No");
        System.out.println(isMaxHeap(b, 0, a.length - 1) ? "Yes" : "No");
    }
}
