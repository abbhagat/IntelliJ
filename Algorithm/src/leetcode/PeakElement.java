package leetcode;

// A peak element is an element that is greater than it's neighbour
// a[i] > a[i+1] return a[i]
public class PeakElement {

  private static int findPeakElement(int[] a) {
    int low = 0, high = a.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (a[mid] > a[mid + 1]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return a[low];
  }

  private static int findPeakElements(int[] a) {
    for (int i = 0; i + 1 < a.length; i++) {
      if (a[i] > a[i + 1]) {
        return a[i];
      }
    }
    return a[a.length - 1];
  }

  public static void main(String[] args) {
    int[] a = new int[]{1, 3, 2};
    System.out.println(findPeakElement(a) + "\t" + findPeakElements(a));
    a = new int[]{4, 5, 3};
    System.out.println(findPeakElement(a) + "\t" + findPeakElements(a));
    a = new int[]{1, 2, 1, 3, 5, 6, 4};
    System.out.println(findPeakElement(a) + "\t" + findPeakElements(a));
    a = new int[]{1, 2, 3, 1};
    System.out.println(findPeakElement(a) + "\t" + findPeakElements(a));
    a = new int[]{1, 3, 20, 4, 1, 0};
    System.out.println(findPeakElement(a) + "\t" + findPeakElements(a));
  }
}
