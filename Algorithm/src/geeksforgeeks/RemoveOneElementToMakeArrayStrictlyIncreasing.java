package geeksforgeeks;

public class RemoveOneElementToMakeArrayStrictlyIncreasing {

  public boolean canBeIncreasing(int[] a) {
    int count = 0;
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] >= a[i + 1]) {
        count++;
        if (count > 1) {
          return false;
        }
        if (i > 0 && a[i - 1] >= a[i + 1]) {
          a[i + 1] = a[i];
        }
      }
    }
    return true;
  }

  public static Integer elementToRemove(int[] a) {
    int count = 0;
    Integer n = null;
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] >= a[i + 1]) {
        count++;
        if (count > 1) {
          return null;
        }
        if (i > 0 && a[i - 1] >= a[i + 1]) {  // elementToRemove if removing a[i] OR a[i+1] works
          n = a[i + 1];
          a[i + 1] = a[i];                  // simulate removing a[i+1]
        } else {
          n = a[i];
        }
      }
    }
    return n;
  }

  public static void main(String[] args) {
    System.out.println(elementToRemove(new int[]{1, 2, 3}));
    System.out.println(elementToRemove(new int[]{5, 4, 5}));
    System.out.println(elementToRemove(new int[]{1, 5, 4, 6}));
    System.out.println(elementToRemove(new int[]{1, 2, 10, 5, 7}));
  }
}
