package gfg;

public class FindInsertionPositionInSortedArray {

  private static int findPosition(int[] a, int n) {
    for (int i = 0; i < a.length; i++) {
      if (n <= a[i]) {
        return i;
      }
    }
    return a.length;
  }

  public static void main(String[] args) {
    System.out.println(findPosition(new int[]{1, 3, 5, 6}, 5));
    System.out.println(findPosition(new int[]{1, 3, 5, 6}, 2));
    System.out.println(findPosition(new int[]{1, 3, 5, 6}, 7));
    System.out.println(findPosition(new int[]{1, 3, 5, 6}, 0));
  }
}
