package matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static util.CommonUtils.printMatrix;

// Time Complexity: O(n log n)
// Auxiliary Space: O(M+N)
public class SortBoundaryElementsOfMatrix {

  private static List<Integer> getBoundaryElements(int[][] M, List<Integer> list) {
    int R1 = 0, R2 = M.length - 1;
    int C1 = 0, C2 = M[0].length - 1;
    for (int i = C1; i <= C2; i++) {
      list.add(M[R1][i]);
    }
    for (int i = R1 + 1; i <= R2; i++) {
      list.add(M[i][C2]);
    }
    for (int i = C2 - 1; i >= C1; i--) {
      list.add(M[R2][i]);
    }
    for (int i = R2 - 1; i > R1; i--) {
      list.add(M[i][C1]);
    }
    return list;
  }

  private static void sort(int[][] M, List<Integer> list) {
    int R1 = 0, C1 = 0, R2 = M.length - 1, C2 = M[0].length - 1, j = 0;
    for (int i = C1; i <= C2; i++) {
      M[R1][i] = list.get(j++);
    }
    for (int i = R1 + 1; i <= R2; i++) {
      M[i][C2] = list.get(j++);
    }
    for (int i = C2 - 1; i >= C1; i--) {
      M[R2][i] = list.get(j++);
    }
    for (int i = R2 - 1; i > R1; i--) {
      M[i][C1] = list.get(j++);
    }
  }

  public static void main(String[] args) {
    final int[][] M = new int[][]{
        {1, 2, 3, 4, 0},
        {1, 1, 1, 1, 2},
        {1, 2, 2, 2, 4},
        {1, 9, 3, 1, 7}
    };
    List<Integer> list = getBoundaryElements(M, new ArrayList<>());
    list.sort(Comparator.comparingInt(x -> x));
    sort(M, list);
    printMatrix(M);
  }
}
