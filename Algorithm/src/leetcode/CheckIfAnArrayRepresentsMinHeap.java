package leetcode;

public class CheckIfAnArrayRepresentsMinHeap {
    private static boolean isMinHeap(int[] a, int i, int n) {
        if (n <= 2 * (i + 1)) {
            return true;
        }
        int left  = 2 * i + 1;
        int right = 2 * i + 2;
        if (a[i] <= a[left] && a[i] <= a[right] && isMinHeap(a, left, n) && isMinHeap(a, right, n)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {90, 15, 10, 7, 12, 2, 7, 3};
        int[] b = {10, 50, 80, 55, 57, 85, 90};
        System.out.println(isMinHeap(b, 0, a.length - 1) ? "Yes" : "No");
        System.out.println(isMinHeap(a, 0, a.length - 1) ? "Yes" : "No");
    }
}
