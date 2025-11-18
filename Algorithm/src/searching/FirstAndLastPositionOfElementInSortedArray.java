package searching;

// Time Complexity O(n)
public class FirstAndLastPositionOfElementInSortedArray {

  private static int[] searchRange(int[] a, int n) {
    int[] result = {-1, -1};
    int i;
    for (i = 0; i < a.length; i++) {
      if (a[i] == n) {
        result[0] = i;
        break;
      }
    }
    if (result[0] == -1) {
      return result;
    }
    for (int j = a.length - 1; j > i; j--) {
      if (a[j] == n) {
        result[1] = j;
        break;
      }
    }
    return result;
  }

  private static int binarySearchStartIndex(int[] a, int low, int high, int n) {
    if (low <= high) {
      int mid = (low + high) / 2;
      if ((mid == 0 || a[mid - 1] != n) && a[mid] == n) {
        return mid;
      }
      return n < a[mid] ? binarySearchStartIndex(a, low, mid - 1, n) : binarySearchStartIndex(a, mid + 1, high, n);
    }
    return -1;
  }

  private static int binarySearchEndIndex(int[] a, int low, int high, int n) {
    if (low <= high) {
      int mid = (low + high) / 2;
      if ((mid == 0 || a[mid - 1] == n) && a[mid] != n) {
        return mid - 1;
      }
      return n < a[mid] ? binarySearchEndIndex(a, low, mid - 1, n) : binarySearchEndIndex(a, mid + 1, high, n);
    }
    return a.length - 1;
  }

  public static void main(String[] args) {
    for (int x : searchRange(new int[]{1, 1, 2, 2, 2}, 2)) {
      System.out.print(x + " ");
    }
    System.out.println();
    for (int x : searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)) {
      System.out.print(x + " ");
    }
    System.out.println();
    for (int x : searchRange(new int[]{5, 7, 7, 8, 8, 10}, 2)) {
      System.out.print(x + " ");
    }
    System.out.println();
    int[] a = {1, 1, 2, 2, 2};
    int n = 2, count = 0;
    int startIndex = binarySearchStartIndex(a, 0, a.length - 1, n);
    if (startIndex != -1) {
      int endIndex = binarySearchEndIndex(a, startIndex + 1, a.length - 1, n);
      count = startIndex == endIndex ? 1 : endIndex - startIndex + 1;
      System.out.println(startIndex + " " + endIndex);
    }
    System.out.println(count);
  }
}
