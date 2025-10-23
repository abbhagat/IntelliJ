package searching;

// Time  Complexity: O(log n)
// Space Complexity: O(1)
public class SearchAnElementInSortedAndRotatedArray {

  private static int pivotedBinarySearch(int[] a, int n) {
    int low = 0, high = a.length - 1;
    int pivot = findPivot(a);
    if (pivot == high) {
      return binarySearch(a, low, high, n);
    }
    if (a[pivot] == n) {
      return pivot;
    }
    return a[low] > n ? binarySearch(a, pivot + 1, high, n) : binarySearch(a, low, pivot - 1, n);
  }

  private static int findPivot(int[] a) {
    int low = 0, high = a.length - 1, mid = 0;
    while (low <= high) {
      mid = (low + high) / 2;
      if (a[mid] == a[high]) {
        high--;
      } else if (a[mid] > a[mid + 1]) {
        return mid;
      } else if (a[low] > a[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return mid;
  }

  private static int binarySearch(int[] a, int low, int high, int n) {
    if (low <= high) {
      int mid = (low + high) / 2;
      if (n == a[mid]) {
        return mid;
      }
      return n < a[mid] ? binarySearch(a, low, mid - 1, n) : binarySearch(a, mid + 1, high, n);
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {4, 5, 1, 2, 3};
    System.out.println(pivotedBinarySearch(a, 2) != -1 ? "Present" : "Not Present");
    System.out.println(pivotedBinarySearch(a, 5) != -1 ? "Present" : "Not Present");
    System.out.println(pivotedBinarySearch(a, 1) != -1 ? "Present" : "Not Present");
    System.out.println(pivotedBinarySearch(a, 9) != -1 ? "Present" : "Not Present");
  }
}
