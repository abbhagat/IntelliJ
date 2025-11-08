package leetcode;

/**
 * The method is a recursive function that checks if a given array represents a max heap.
 * For each node, it checks the left and right children and then recursively checks the subtrees.
 * The recursion depth is proportional to the height of the heap, which is O(log n).
 * Each recursive call performs a constant amount of work. Overall Complexity is O(n).
 */
// Time Complexity: O(n) where n is the number of elements in the array
public class CheckIfAnArrayRepresentsMinHeap {

    private static boolean isMinHeap(int[] a, int i, int n) {
        if (n <= 2 * (i + 1)) {
            return true;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        return a[i] <= a[left] && a[i] <= a[right] && isMinHeap(a, left, n) && isMinHeap(a, right, n);
    }

    public static void main(String[] args) {
        int[] a = {90, 15, 10, 7, 12, 2, 7, 3};
        int[] b = {10, 50, 80, 55, 57, 85, 90};
        System.out.println(isMinHeap(b, 0, a.length - 1));
        System.out.println(isMinHeap(a, 0, a.length - 1));
    }
}
