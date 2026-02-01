package searching;

// Given an int a[] = {4, 3, 2, 7, 8, 2, 3, 1} with numbers from 1 to 8. But 5 and 6 are replaced with 2 and 3 .
// So 2 and 3 gets repeated and 5 and 6 are missing. You need to find all the missing numbers.

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class MissingNumber3 {

  private static void findMissing(int[] a) {
    int n = a.length;
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
    findMissing(new int[]{4, 3, 2, 7, 8, 2, 3, 0});
    findMissing(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    findMissing(new int[]{1, 3, 2, 2, 8, 2, 3, 1});
    findMissing(new int[]{1, 1});
    findMissing(new int[]{1, 2, 3});
    findMissing(new int[]{1, 2, 3, 3, 5});
    findMissing(new int[]{1, 2, 3, 5});
  }
}
