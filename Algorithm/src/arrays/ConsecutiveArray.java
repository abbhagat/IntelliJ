package arrays;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveArray {

  public static void main(String[] args) {
    char[] a = {'A', 'B', 'B', 'C', 'D', 'E', 'R', 'R', 'D', 'X', 'Y', 'Z'};
    Set<Character> set = new HashSet<>();
    for (int i = 1; i < a.length; i++) {
      if (Math.abs(a[i - 1] - a[i]) == 1) {
        set.add(a[i - 1]);
        set.add(a[i]);
      }
    }
    set.forEach(e -> System.out.print(e + " "));
  }
}
