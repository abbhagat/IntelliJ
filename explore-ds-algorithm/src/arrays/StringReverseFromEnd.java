package arrays;

/*
 * Input  :- String str1 = "Today is Wednesday";
 * Output :- String str2 = "yadsendeW si yadoT"
 * Output :- String str2 = "yadoT si yadsendeW"
 */

public class StringReverseFromEnd {

  public static void main(String[] args) {
    String str = "Today is Wednesday";
    System.out.println(reverse(str));
    for (String s : str.split(" ")) {
      System.out.print(reverse(s));
      System.out.print(" ");
    }
  }

  private static char[] reverse(String str) {
    char[] c = str.toCharArray();
    for (int i = 0, j = c.length - 1; i < j; i++, j--) {
      c[i] = (char) (c[i] ^ c[j]);
      c[j] = (char) (c[i] ^ c[j]);
      c[i] = (char) (c[i] ^ c[j]);
    }
    return c;
  }
}
