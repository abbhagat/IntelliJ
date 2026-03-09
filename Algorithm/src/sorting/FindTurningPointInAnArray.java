package sorting;

// Time Complexity : O(log n)
public class FindTurningPointInAnArray {

  public static int findPeakAscToDesc(int[] a) {
    int low = 0, high = a.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (a[mid] < a[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;   // index of peak
  }

  public static int findPeakDescToAsc(int[] a) {
    int low = 0, high = a.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (a[mid] > a[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;   // index of peak
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 2};
    System.out.println(a[findPeakAscToDesc(a)]);
    int[] b = {3, 1, 2};
    System.out.println(b[findPeakDescToAsc(b)]);
    int[] c = {1, 3, 8, 12, 9, 5, 2};
    System.out.println(c[findPeakAscToDesc(c)]);
    int[] d = {9, 8, 7, 6, 10, 11, 12};
    System.out.println(d[findPeakDescToAsc(d)]);
  }
}
