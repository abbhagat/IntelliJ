package searching;

// Time  Complexity: O(log n)
// Space Complexity: O(1)
public class SearchAnElementInASortedArrayOfInfiniteNumbers {

  private static int search(int[] a, int n) {
    int low = 0, high = 1;
    while (n > a[high]) {
      int t = high + 1;
      high += (high - low + 1) * 2;
      low = t;
    }
    return BinarySearch.binarySearch(a, low, high, n);
  }

  public static void main(String[] args) {
    int[] a = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
    System.out.println(search(a, 3));
    System.out.println(search(a, 5));
    System.out.println(search(a, 1));
    System.out.println(search(a, 10));
    System.out.println(search(a, 11));
  }
}
