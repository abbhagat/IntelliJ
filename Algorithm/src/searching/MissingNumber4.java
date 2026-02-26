package searching;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber4 {

  private static void findMissing(int[] a) {
    int min = Arrays.stream(a).min().getAsInt();
    int max = Arrays.stream(a).max().getAsInt();
    int count = 0;
    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
    for (int i = min; i <= max && count < 2; i++) {
      if (!set.contains(i)) {
        System.out.print(i + " ");
        count++;
      }
    }
    if(count == 0) {
      System.out.print((max + 1) + "\t" + (max + 2));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    findMissing(new int[]{21, 24, 23, 26});
    findMissing(new int[]{2, 3, -7, 6, 8, 1, -10, 15});
  }
}
