package stack;

/**
 * Input : exp = "}{" Output : 2
 * We need to change '}' to '{' and '{' to '}' so that the expression becomes balanced, the balanced expression is '{}'
 * Input : exp = "}{{}}{{{" Output : 3 The balanced expression is "{{{}}{}}"
 */

public class MinBracketRemovalToMakeBracketBalanced {

  private static int countMinReversals(char[] exp) {
    if (exp.length % 2 != 0) {
      return -1;
    }
    int open = 0, close = 0;
    for (char c : exp) {
      if (c == '{') {
        open++;
      } else if (c == '}' && open > 0) {
        open--;
      } else {
        close++;
      }
    }
    return (open + 1) / 2 + (close + 1) / 2;
  }

  public static void main(String[] args) {
    System.out.println(countMinReversals("}{".toCharArray()));
    System.out.println(countMinReversals("}{{}}{{{".toCharArray()));
  }
}
