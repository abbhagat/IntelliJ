package stack;

/**
 * When checking whether the string is valid, we only cared about the "balance": the number of extra, open left brackets as we parsed through the string.
 * For example, when checking whether '(()())' is valid, we had a balance of 1, 2, 1, 2, 1, 0
 * as we parse through the string: '(' has 1 left bracket, '((' has 2, '(()' has 1, and so on.
 * This means that after parsing the first i symbols, (which may include asterisks,)
 * we only need to keep track of what the balance could be.
 * For example, if we have string '(***)', then as we parse each symbol,
 * the set of possible values for the balance is
 * [1] for '(';
 * [0, 1, 2] for '(*';
 * [0, 1, 2, 3] for '(**';
 * [0, 1, 2, 3, 4] for '(***';
 * [0, 1, 2, 3] for '(***)'.
 */

public class CheckValidString {
  // min -> minimum number of open bracket
  // max -> maximum number of open bracket

  public static boolean checkValidString(String exp) {
    int min = 0;
    int max = 0;
    for (char ch : exp.toCharArray()) {
      if (ch == '(') {  // If current char is '('
        min++;
        max++;
      }
      else if (ch == ')') {  // If current char is ')'
        min--;
        max--;
      } else {    // If current char is '*'
        min--;   // '*' can act as ')'
        max++;  // '*' can act as '('
      }
      if (max < 0) {   // Too many closing brackets
        return false;
      }
      if (min < 0) {  // min should never be negative
          min = 0;
      }
    }
    return min == 0;  // Expression is valid only if all brackets can be balanced
  }

  public static void main(String[] args) {
    System.out.println(checkValidString(")("));
    System.out.println(checkValidString("(*"));
    System.out.println(checkValidString("(()())"));
    System.out.println(checkValidString("(***)"));
    System.out.println(checkValidString("())()"));
  }
}
