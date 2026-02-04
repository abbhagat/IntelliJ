package geeks;

public class ParseIntImplementation {

  public static int parseInt(String s) {
    int n = 0, j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      n += Character.getNumericValue(s.charAt(i)) * Math.pow(10, j++);
    }
    return n;
  }

  public static void main(String[] args) {
    System.out.println(parseInt("235"));
    System.out.println(parseInt("1235"));
    System.out.println(parseInt("14235"));
  }
}
