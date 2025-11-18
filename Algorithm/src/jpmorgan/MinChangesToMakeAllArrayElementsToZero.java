package jpmorgan;

public class MinChangesToMakeAllArrayElementsToZero {

  private static int minimumChangesToMakeAllArrayElementsToZero(int[] a) {
    int change = 0;
    for (int i = 0; i + 1 < a.length; i++) {
      if (a[i] == 1 && a[i + 1] == 0) {
        change++;
      }
    }
    if (a[a.length - 1] == 1) {
      change++;
    }
    return change;
  }

  public static void main(String[] args) {
    System.out.println(minimumChangesToMakeAllArrayElementsToZero(new int[]{1, 1, 0, 0, 0, 1, 0, 1, 1}));
    System.out.println(minimumChangesToMakeAllArrayElementsToZero(new int[]{1, 1, 1, 1}));
  }
}
