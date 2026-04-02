package leetcode;

public class CommonElementsInTwoSortedArray {

  private static void commonElements(int[] a, int[] b) {
    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length) {
      if (a[i] == b[j]) {
        System.out.print(a[i] + " ");
        i++;
        j++;
      } else {
        k = a[i] < b[j] ? i++ : j++;
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    commonElements(new int[]{1, 2, 4, 5, 6, 10}, new int[]{1, 3, 4, 7, 8, 9, 10});
    commonElements(new int[]{1, 2, 3, 4, 5, 6, 10}, new int[]{1, 3, 3, 4, 7, 8, 9, 10});
  }
}
