package gfg;

/**
 * Given an unsorted array and a position ‘P’.
 * Return the element that is likely to come to the given location upon sorting the array.
 * Solution: Iterate the array and find how many elements are less than the given position element.
 */
// Time Complexity: O(n)
public class FindElementPositionAfterSorting {

  private static void findElementPositionAfterSorting(int[] a, int pos) {
    int count = 0, n = a[pos];
    for (int x : a) {
      if (x < n) {  // Find the count of elements in the array which are <= n
        count++;
      }
    }
    System.out.println("Position Index " + count);
  }

  public static void main(String[] args) {
    int[] a = {4, 5, 1, 2, 4};
    findElementPositionAfterSorting(a, 0);
    findElementPositionAfterSorting(a, 1);
    findElementPositionAfterSorting(a, 2);
    findElementPositionAfterSorting(a, 3);
    findElementPositionAfterSorting(a, 4);
  }
}
