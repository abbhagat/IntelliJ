package amazon;

// Time  Complexity : O(n)
public class ReturnWithComma {

  public static String returnWithCommas(String s, final int k) {
    int j = 1;
    for (int i = s.length() - 1; i > 0; i--) {
      if (j % k == 0) {
        s = s.substring(0, i) + "," + s.substring(i);
      }
      j++;
    }
    return s;
  }

  public static void main(String[] args) {
    System.out.println(returnWithCommas("1010503", 3));
    System.out.println(returnWithCommas("1010503123", 3));
  }
}
