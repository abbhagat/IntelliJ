package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.min;

public class MinPathTriangleSum {

  private static int minPathSum(List<List<Integer>> triangle) {
    List<Integer> list = new ArrayList<>();
    int level = triangle.size() - 1, result = 0;
    for (int i = level - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        if (!list.isEmpty()) {
          result = min(list.get(j), list.get(j + 1)) + triangle.get(i).get(j);
        } else {
          list.add(j, result);
        }
      }
    }
    return list.get(0);
  }

  public static void main(String[] args) {
    System.out.println(minPathSum(Arrays.asList(
        Arrays.asList(2),
        Arrays.asList(3, 4),
        Arrays.asList(6, 5, 7),
        Arrays.asList(4, 1, 8, 3)
    )));
  }
}
