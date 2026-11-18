package searching;

// Time  Complexity : O(log n)
// Space Complexity : O(log n)
public class NoOfTimesAGivenNumOccursInASortedArray {

  private static int binarySearchStartIndex(int[] a, int low, int high, int n) {
    if (low <= high) {
      int mid = (low + high) / 2;
      if ((mid == 0 || a[mid - 1] != n) && a[mid] == n) {
        return mid;
      }
      return n <= a[mid] ? binarySearchStartIndex(a, low, mid - 1, n) : binarySearchStartIndex(a, mid + 1, high, n);
    }
    return -1;
  }

  private static int binarySearchEndIndex(int[] a, int low, int high, int n) {
    if (low <= high) {
      int mid = (low + high) / 2;
      if ((mid == a.length - 1 || a[mid + 1] != n) && a[mid] == n) {
        return mid;
      }
      return n < a[mid] ? binarySearchEndIndex(a, low, mid - 1, n) : binarySearchEndIndex(a, mid + 1, high, n);
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {5, 7, 7, 8, 10};
    int count = 0;
    int startIndex = binarySearchStartIndex(a, 0, a.length - 1, 8);
    if (startIndex != -1) {
      int endIndex = binarySearchEndIndex(a, 0, a.length - 1, 8);
      count = startIndex == endIndex ? 1 : endIndex - startIndex + 1;
      System.out.println(startIndex == endIndex ? startIndex : startIndex + " " + endIndex);
    }
    System.out.println(count);
  }
}
