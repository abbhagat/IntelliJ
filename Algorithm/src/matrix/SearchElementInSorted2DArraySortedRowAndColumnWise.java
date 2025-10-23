package matrix;

public class SearchElementInSorted2DArraySortedRowAndColumnWise {

  // Time Complexity : O(m + n)
  private static boolean search(int[][] M, int n) {
    int R1 = 0, R2 = M.length - 1;
    int C1 = 0, C2 = M[0].length - 1;
    while (R1 <= R2 && C1 <= C2) {
      if (n < M[R1][C2]) {
        C2--;
      } else if (n > M[R1][C2]) {
        R1++;
      } else {
        System.out.println("M[" + R1 + "]" + "[" + C2 + "]");
        return true;
      }
    }
    return false;
  }

  // Time Complexity : O log(m*n)
  private static boolean searchMatrix(int[][] M, int num) {
    int m = M.length, n = M[0].length, low = 0, high = m * n - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      int key = M[mid / n][mid % n];
      if (key == num) {
        System.out.println("M[" + mid / n + "]" + "[" + mid % n + "]");
        return true;
      } else if (num < key) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] M;
    M = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    System.out.println(search(M, 5) ? "Present" : "Not Present");
    System.out.println(searchMatrix(M, 5) ? "Present" : "Not Present");
    M = new int[][]{{1, 1}};
    System.out.println(search(M, 2) ? "Present" : "Not Present");
    System.out.println(searchMatrix(M, 2) ? "Present" : "Not Present");
  }
}
