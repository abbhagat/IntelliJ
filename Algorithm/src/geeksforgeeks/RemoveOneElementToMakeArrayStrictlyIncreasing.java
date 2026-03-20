package geeksforgeeks;

public class RemoveOneElementToMakeArrayStrictlyIncreasing {

  public static Integer check(int[] a) {
    int count = 0, n = 0;
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] >= a[i + 1]) {
        count++;
        if (count > 1) {
          return null;
        }
        if (i > 0 && a[i - 1] >= a[i + 1]) {  // Check if removing a[i] OR a[i+1] works
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
    System.out.println(check(new int[]{5, 4, 5}));
    System.out.println(check(new int[]{1, 2, 10, 5, 7}));
  }
}
