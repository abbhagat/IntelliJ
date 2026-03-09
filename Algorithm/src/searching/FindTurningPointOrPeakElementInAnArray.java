package searching;

// Time Complexity : O(log n)
public class FindTurningPointOrPeakElementInAnArray {

  public static void findPeakAscToDesc(int[] a) {
    int low = 0, high = a.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (a[mid] > a[mid + 1]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    System.out.println(a[low]);   // low is the index of peak element
  }

  public static void findPeakDescToAsc(int[] a) {
    int low = 0, high = a.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (a[mid] < a[mid + 1]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    System.out.println(a[low]);   // low is the index of peak element
  }

  public static void main(String[] args) {
    findPeakAscToDesc(new int[] {1, 3, 2});
    findPeakDescToAsc(new int[] {3, 1, 2});
    findPeakAscToDesc(new int[] {1, 3, 8, 12, 9, 5, 2});
    findPeakDescToAsc(new int[] {9, 8, 7, 6, 10, 11, 12});
  }
}
