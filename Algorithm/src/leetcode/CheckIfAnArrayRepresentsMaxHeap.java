package leetcode;

/**
 * The method is a recursive function that checks if a given array represents a max heap.
 * For each node, it checks the left and right children and then recursively checks the subtrees.
 * The recursion depth is proportional to the height of the heap, which is O(log n).
 * Each recursive call performs a constant amount of work. Overall Complexity is O(n).
 */
// Time Complexity: O(n) where n is the number of elements in the array
public class CheckIfAnArrayRepresentsMaxHeap {

  private static boolean isMaxHeap(int[] a) {
    for (int i = 0; i <= (a.length - 2) / 2; i++) {
      int left  = 2 * i + 1;
      int right = 2 * i + 2;
      if (a[i] < a[left]) {
        return false;
      }
      if (right < a.length && a[i] < a[right]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isMaxHeap(new int[]{90, 15, 10, 7, 12, 2, 7, 3}));
    System.out.println(isMaxHeap(new int[]{10, 50, 80, 55, 57, 85, 90}));
    System.out.println(isMaxHeap(new int[]{90, 15, 10, 7, 12, 2}));
    System.out.println(isMaxHeap(new int[]{9, 15, 10, 7, 12, 11}));
  }
}
