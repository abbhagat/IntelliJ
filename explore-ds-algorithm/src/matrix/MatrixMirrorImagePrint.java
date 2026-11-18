package matrix;

import static util.CommonUtils.printMatrix;
import static util.CommonUtils.swap;

public class MatrixMirrorImagePrint {

  private static void mirrorImage(int[][] M) {
    for (int[] a : M) {
      int j = a.length - 1;
      for (int i = 0; i < j; i++) {
        swap(a, i, j);
        j--;
      }
    }
  }

  public static void main(String[] args) {
    int[][] M = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    printMatrix(M);
    System.out.println();
    mirrorImage(M);
    printMatrix(M);
    System.out.println();
  }
}
