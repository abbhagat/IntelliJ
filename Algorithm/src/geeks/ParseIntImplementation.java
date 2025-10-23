package geeks;

public class ParseIntImplementation {

  public static int parseInt(String s) {
    int num = 0, k = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      num += (int) ((s.charAt(i) - '0') * Math.pow(10, k++));
    }
    return num;
  }

  public static void main(String[] args) {
    System.out.println(parseInt("235"));
  }
}
