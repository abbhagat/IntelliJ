package amazon;

// Time  Complexity : O(n)
public class ReturnWithComma {

  public static StringBuilder returnWithCommas(String s, int k) {
    StringBuilder sb = new StringBuilder();
    int j = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
      if (j % k == 0) {
        sb.append(',');
      }
      j++;
    }
    return sb.reverse();
  }

  public static void main(String[] args) {
    System.out.println(returnWithCommas("1010503",    3));
    System.out.println(returnWithCommas("1010503123", 3));
  }
}
