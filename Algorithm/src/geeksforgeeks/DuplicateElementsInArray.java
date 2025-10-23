package geeksforgeeks;

public class DuplicateElementsInArray {

  private static void findDuplicates(int[] a) {
    int n = a.length;
    for (int x : a) {
      int i = x % n;
      a[i] += n;
    }
    System.out.print("Duplicate Elements are : ");
    for (int i = 0; i < n; i++) {
      if (a[i] >= n * 2) {
        System.out.print(i + " ");
      }
    }
  }

  public static void main(String[] args) {
    findDuplicates(new int[]{1, 1, 2, 3, 2, 3, 4, 5, 6});
  }
}
