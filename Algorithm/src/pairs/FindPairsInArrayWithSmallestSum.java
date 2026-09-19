package pairs;

// Time  Complexity : O(k*n) where n = a.length
// Space Complexity : O(n)
public class FindPairsInArrayWithSmallestSum {

  // If the array is 1D then divide it from mid into two arrays of a and b and use the same logic below
  private static void findKPairsInArrayWithSmallestSum(int[] a, int[] b, int k) {
    if (k > a.length * b.length) {
      System.out.println("K pairs don't exist");
      return;
    }
    int[] c = new int[a.length];
    while (k != 0) {
      int i = getMinIndex(a, b, c);
      System.out.print("(" + a[i] + ", " + b[c[i]] + ") ");
      c[i]++;
      k--;
    }
  }

  private static int getMinIndex(int[] a, int[] b, int[] c) {
    int index  = 0, minSum = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; i++) {
      if (c[i] < b.length && a[i] + b[c[i]] < minSum) {
        index = i;
        minSum = a[i] + b[c[i]];
      }
    }
    return index;
  }

  public static void main(String[] args) {
    findKPairsInArrayWithSmallestSum(new int[]{1, 2}, new int[]{3, 4}, 3);
    System.out.println();
    findKPairsInArrayWithSmallestSum(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
    System.out.println();
    findKPairsInArrayWithSmallestSum(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
  }
}
