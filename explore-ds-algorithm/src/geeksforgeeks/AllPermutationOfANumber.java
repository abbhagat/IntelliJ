package geeksforgeeks;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time Complexity :- O(n * n!)
public class AllPermutationOfANumber {

  private static void permutation(char[] a, int start, int end) {
    if (start == end) {
      printArray(a);
      return;
    }
    for (int i = start; i <= end; i++) {
      swap(a, i, start);
      permutation(a, start + 1, end);
      swap(a, i, start);
    }
  }

  public static void main(String[] args) {
    char[] a = String.valueOf(123).toCharArray();
    permutation(a, 0, a.length - 1);
    System.out.println();
    char[] b = String.valueOf(102).toCharArray();
    permutation(b, 0, b.length - 1);
  }
}
