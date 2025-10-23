package strings;

import static util.CommonUtils.swap;

// Time Complexity: O(n*n!) There are n! permutations and it requires O(n) time to print a permutation.
public class AllPossibleCombinationOfString {

  private static void permute(char[] c, int start, int end) {
    if (start == end) {
      System.out.println(c);
      return;
    }
    for (int i = start; i <= end; i++) {
      swap(c, i, start);
      permute(c, start + 1, end);
      swap(c, i, start);
    }
  }

  public static void main(String[] args) {
    char[] c = {'A', 'B', 'C'};
    permute(c, 0, c.length - 1);
  }
}
