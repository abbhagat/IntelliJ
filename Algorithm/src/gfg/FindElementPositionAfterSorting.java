package gfg;

/**
 * Given an unsorted array and a position ‘P’.
 * Return the element that is likely to come to the given location upon sorting the array.
 * Solution: Iterate the array and find how many elements are less than the given position element.
 */
// Time Complexity: O(n)
public class FindElementPositionAfterSorting {

  private static int findElementPositionAfterSorting(int[] a, int pos) {
    int count = 0, n = a[pos];
    for (int x : a) {
      if (x < n) {  // Find the count of elements in the array which are <= n
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] a = {4, 5, 1, 2, 4};
    System.out.println("Position Index " + findElementPositionAfterSorting(a, 0));
    System.out.println("Position Index " + findElementPositionAfterSorting(a, 1));
    System.out.println("Position Index " + findElementPositionAfterSorting(a, 2));
    System.out.println("Position Index " + findElementPositionAfterSorting(a, 3));
    System.out.println("Position Index " + findElementPositionAfterSorting(a, 4));
  }
}
