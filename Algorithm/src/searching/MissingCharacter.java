package searching;

public class MissingCharacter {

  private static char findMissingCharacter(String str) {
    char[] a = str.toLowerCase().toCharArray();
    char min = a[0], max = a[0];
    int sum1 = 0;
    for (char c : a) {
      max = max < c ? c : max;
      min = min > c ? c : min;
      sum1 += c;
    }
    int n = a.length + 1;
    int sum2  = n * (min + max) / 2;
    return (char) (sum2 - sum1);
  }

  public static void main(String[] args) {
    System.out.println("Missing character : " + findMissingCharacter("ecAfD"));
    System.out.println("Missing character : " + findMissingCharacter("ebAfD"));
  }
}
