package adobe;

// Time Complexity : log(n)
public class MissingNumberInSortedArray {

  private static int findMissingNumber(int[] a) {
    int low = 0, high = a.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (mid < a[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    System.out.println(findMissingNumber(new int[]{0, 1, 2, 3, 5}));
    System.out.println(findMissingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9, 10}));
    System.out.println(findMissingNumber(new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9, 10}));
  }
}
