package searching;

// Time Complexity O(log n)
public class FindMinInARotatedSortedArray {

  private static int findMin(int[] a) {
    int low = 0, high = a.length - 1, mid = 0;
    while (low < high) {
      mid = (low + high) / 2;
      if (a[mid] == a[high]) {
        high--;
      } else if (a[mid] > a[mid + 1]) {
        return a[mid + 1];
      } else if (a[mid] > a[high]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return a[mid];
  }

  private static int findMin(int[] a, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      if (a[mid] == a[high]) {
        return findMin(a, low, high - 1);
      }
      return a[mid] > a[high] ? findMin(a, mid + 1, high) : findMin(a, low, mid);
    }
    return a[high];
  }

  public static void main(String[] args) {
    int[] a = new int[]{5, 6, 1, 1, 1, 2, 3, 4, 4, 5};
    System.out.println("Min : " + findMin(a) + "\t" + findMin(a, 0, a.length - 1));

    a = new int[]{1, 2, 3, 4};
    System.out.println("Min : " + findMin(a) + "\t" + findMin(a, 0, a.length - 1));

    a = new int[]{1};
    System.out.println("Min : " + findMin(a) + "\t" + findMin(a, 0, a.length - 1));

    a = new int[]{1, 2};
    System.out.println("Min : " + findMin(a) + "\t" + findMin(a, 0, a.length - 1));

    a = new int[]{2, 1};
    System.out.println("Min : " + findMin(a) + "\t" + findMin(a, 0, a.length - 1));

    a = new int[]{5, 6, 7, 1, 2, 3, 4};
    System.out.println("Min : " + findMin(a) + "\t" + findMin(a, 0, a.length - 1));

    a = new int[]{1, 2, 3, 4, 5, 6, 7};
    System.out.println("Min : " + findMin(a) + "\t" + findMin(a, 0, a.length - 1));

    a = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
    System.out.println("Min : " + findMin(a) + "\t" + findMin(a, 0, a.length - 1));

    a = new int[]{3, 4, 5, 1, 2};
    System.out.println("Min : " + findMin(a) + "\t" + findMin(a, 0, a.length - 1));
  }
}
