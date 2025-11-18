package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInAnArray {

  public static void arrayChange(int[] a, int[][] operations) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      map.put(a[i], i);
    }
    for (int[] operation : operations) {
      Integer i = map.get(operation[0]);
      if (i != null) {
        a[i] = operation[1];
        map.put(a[i], i);
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2};
    int[][] operations = {{1, 3}, {2, 1}, {3, 2}};
    arrayChange(a, operations);
    System.out.println(Arrays.toString(a));
  }
}
