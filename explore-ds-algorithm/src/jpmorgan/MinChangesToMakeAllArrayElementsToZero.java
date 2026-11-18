package jpmorgan;

public class MinChangesToMakeAllArrayElementsToZero {

  private static int minimumChangesToMakeAllArrayElementsToZero(int[] a) {
    int change = a[0];  // change = a[0] + Σ max(0, a[i] - a[i-1])
    for (int i = 1; i < a.length; i++) {
      if (a[i] > a[i - 1]) {
        change += a[i] - a[i - 1];
      }
    }
    return change;
  }

  public static void main(String[] args) {
    System.out.println(minimumChangesToMakeAllArrayElementsToZero(new int[]{1, 1, 0, 0, 0, 1, 0, 1, 1}));
    System.out.println(minimumChangesToMakeAllArrayElementsToZero(new int[]{1, 1, 1, 1}));
  }
}
