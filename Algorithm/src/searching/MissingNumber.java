package searching;

import java.util.Arrays;

public class MissingNumber {

  private static int findMissingNumber(int[] a) {
    int sum2 = Arrays.stream(a).sum();
    int min  = Arrays.stream(a).min().getAsInt();
    int max  = Arrays.stream(a).max().getAsInt();
    int n    = max - min + 1;
    int sum1 = n * (min + max) / 2;
    return (char) (sum1 - sum2);
  }

  public static void main(String[] args) {
    int[] a;
    a = new int[] {9, 7, 3, 4, 10, 1, 2, 8, 6};
    System.out.println("Missing Num : " + findMissingNumber(a));
    a = new int[] {4, 1, 2, 5};
    System.out.println("Missing Num : " + findMissingNumber(a));
  }
}
