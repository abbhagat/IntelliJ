package searching;

// Given an unsorted set of numbers from 1 to N with exactly two missing numbers, find those two missing numbers.
// int[] a = {1, 4, 3, 6};   // From 1..6 → missing num are 2 and 5

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class MissingNumber2 {

  private static void findMissing(int[] a) {
    int n = a.length + 2;
    boolean[] isPresent = new boolean[n + 1];
    for (int x : a) {
      if (x > 0 && x <= n) {
        isPresent[x] = true;
      }
    }
    for (int i = 1; i <= n; i++) {
      if (!isPresent[i]) {
        System.out.print(i + "\t");
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    findMissing(new int[]{1, 4, 3, 6});
    findMissing(new int[]{1, 3, 6, 7, 5, 8});
    findMissing(new int[]{1, 2, 3, 4, 5});
  }
}
