package searching;

import java.util.Arrays;

public class MissingNumber {

  private static int findMissingNumber(int[] a) {
    int sum = Arrays.stream(a).sum();
    int min = Arrays.stream(a).min().getAsInt();
    int max = Arrays.stream(a).max().getAsInt();
    int sum2 = 0;
    for (int i = min; i <= max; i++) {
      sum2 += i;
    }
    return sum2 - sum;
  }

  public static void main(String[] args) {
    int[] a = {9, 7, 3, 4, 10, 1, 2, 8, 6};
    System.out.println("Missing Num : " + findMissingNumber(a));
  }
}
