package arrays;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesInCharArray {

  private static void removeDuplicate() {
    final char[] a = {'A', 'B', 'B', 'C', 'D', 'E', 'R', 'R', 'D'};
    Map<Character, Integer> map = new HashMap<>();
    for (char c : a) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    map.forEach((k, v) -> {
      if (v == 1) {
        System.out.print(k + " ");
      }
    });
  }

  public static void main(String[] args) {
    removeDuplicate();
  }
}
