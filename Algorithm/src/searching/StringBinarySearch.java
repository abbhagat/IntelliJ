package searching;

import java.util.Arrays;

public class StringBinarySearch {

  private static int binarySearch(String[] a, int low, int high, String s) {
    if (low <= high) {
      int mid = (low + high) / 2;
      int k = s.compareTo(a[mid]);
      if (k == 0) {
        return mid;
      }
      return k < 0 ? binarySearch(a, low, mid - 1, s) : binarySearch(a, mid + 1, high, s);
    }
    return -1;
  }

  public static void main(String[] args) {
    String[] a = {"A", "B", "C", "F", "I", "S"};
    Arrays.sort(a);
    System.out.println(binarySearch(a, 0, a.length - 1, "F"));
  }

}
