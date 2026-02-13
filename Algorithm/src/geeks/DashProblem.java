package geeks;

/*
 *  1234567    --> 1234567
 *  13244670   --> 1-32*4*4*670
 *  1223504567 --> 12*23-504567
 */

public class DashProblem {

  private static StringBuilder dashProblem(String str) {
    int[] a = str.chars().map(c -> c - '0').toArray();
    boolean prevOdd  = a[0] % 2 == 1;
    boolean prevEven = a[0] % 2 == 0;
    int i;
    StringBuilder sb = new StringBuilder();
    for (i = 1; i < a.length; i++) {
      sb.append(a[i - 1]);
      if (a[i] == 0) {
        continue;
      }
      var isEven = a[i] % 2 == 0;
      var isOdd  = a[i] % 2 != 0;
      if (isEven && prevEven) {
        sb.append("*");
      }
      if (isOdd && prevOdd) {
        sb.append("-");
      }
      if (isEven) {
        prevEven = true;
        prevOdd = false;
      } else {
        prevOdd = true;
        prevEven = false;
      }
    }
    sb.append(a[i - 1]);
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(dashProblem("1234567"));     // 1234567
    System.out.println(dashProblem("13244670"));    // 1-32*4*4*670
    System.out.println(dashProblem("1223504567"));  // 12*23-504567
  }
}
