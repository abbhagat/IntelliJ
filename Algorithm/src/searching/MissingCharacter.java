package searching;

public class MissingCharacter {

  private static char findMissingCharacter(String str) {
    char[] c = str.toLowerCase().toCharArray();
    char min = c[0], max = c[0];
    int sum1 = 0, sum2 = 0;
    for (char x : c) {
      max = max < x ? x : max;
      min = min > x ? x : min;
      sum2 += x;
    }
    for (int i = min; i <= max; i++) {
      sum1 += i;
    }
    return (char) (sum1 - sum2);
  }

  public static void main(String[] args) {
    System.out.println("Missing character : " + findMissingCharacter("ecAfD"));
    System.out.println("Missing character : " + findMissingCharacter("ebAfD"));
  }
}
