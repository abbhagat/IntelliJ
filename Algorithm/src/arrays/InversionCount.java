package arrays;

public class InversionCount {

  public static void main(String[] args) {
    int[] a = {10, 15, 8, 4, 2, 1};
    int count = 0;
    for (int i = 0, j = 0; i < a.length && j + 2 < a.length; i++, j++) {
      if (a[j] > a[j + 1] && a[j + 1] > a[j + 2]) {
        System.out.println(a[j] + " " + a[j + 1] + " " + a[j + 2]);
        count++;
      }
    }
    System.out.println("Total Inversion Count :" + count);
  }
}
