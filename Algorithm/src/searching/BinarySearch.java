package searching;

import java.util.Arrays;

import static util.CommonUtils.printArray;

// Time Complexity O(n log n)
public class BinarySearch {

  public static void main(String[] args) {
    int[] a = {20, 3, 45, 15, 6, 19, 8, 2, 1, 35, 123};
    printArray(a);
    System.out.println(Arrays.binarySearch(a, 0, a.length - 1, 35));
    Arrays.sort(a);
    printArray(a);
    boolean isPresent = binarySearch(a, 0, a.length - 1, 35);
    System.out.println(isPresent ? "Present" : "Not Present");
  }

  public static boolean binarySearch(int[] a, int low, int high, int n) {
    if (low <= high) {
      int mid = (low + high) / 2;
      if (n == a[mid]) {
        System.out.println("Present at Index :" + mid);
        return true;
      }
      return n < a[mid] ? binarySearch(a, low, mid - 1, n) : binarySearch(a, mid + 1, high, n);
    }
    return false;
  }
}
