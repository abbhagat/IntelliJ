package geeks;

import java.util.Arrays;
import static java.lang.Math.abs;

/*
Given a sorted array a[] and a value X, find the k closest elements to X in a[]
Input: K = 4, X = 35 and a[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, only the other closest elements are required.
*/
public class PrintKClosestElementOfAGivenNumberInASortedArray {

  private static void printKClosestElementInAnArray(int[] a, int n, int k) {
    int index = Arrays.binarySearch(a, n);
    int i = index - 1, j = index + 1;
    for (int count = 1; count <= k; count++) {
      if (i < 0) {
        System.out.print(a[j++] + " ");
      } else if (j >= a.length) {
        System.out.print(a[i--] + " ");
      } else {
        System.out.print((abs(n - a[i]) <= abs(n - a[j])) ? a[i--] + " " : a[j++] + " ");
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] a = new int[]{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
    printKClosestElementInAnArray(a, 35, 4);
    printKClosestElementInAnArray(a, 35, 2);
    printKClosestElementInAnArray(a, 12, 3);
    printKClosestElementInAnArray(a, 56, 3);
    printKClosestElementInAnArray(a, 16, 3);
    printKClosestElementInAnArray(a, 55, 3);
  }
}
