package arrays;

/*
 * Input  :- String str = "Today is Wednesday"
 * Output :- String str = "Wednesday is Today"
 */

public class ReadStringFromEnd {

  public static void main(String[] args) {
    String[] s = "Today is Wednesday".split(" ");
    for (int i = s.length - 1; i >= 0; i--) {
      System.out.print(s[i] + " ");
    }
  }
}
