package searching;

import java.util.Arrays;

public class MissingNumber {

  private static int findMissingNumber(int[] a) {
    int sum2 = Arrays.stream(a).sum();
    int min = Arrays.stream(a).min().getAsInt();
    int max = Arrays.stream(a).max().getAsInt();
    int sum1 = 0;
    for (int i = min; i <= max; i++) {
      sum1 += i;
    }
    return sum1 - sum2;
  }

  public static void main(String[] args) {
    int[] a = {9, 7, 3, 4, 10, 1, 2, 8, 6};
    System.out.println("Missing Num : " + findMissingNumber(a));
  }
}
