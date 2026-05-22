package stack;

import static java.lang.Integer.max;

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

  public static boolean checkValidString(String exp) {
    int minOpen = 0;
    int maxOpen = 0;
    for (char ch : exp.toCharArray()) {
      if (ch == '(') {  // If current char is '('
        minOpen++;
        maxOpen++;
      }
      else if (ch == ')') {  // If current char is ')'
        minOpen--;
        maxOpen--;
      }
      // If current char is '*'
      else {
        minOpen--;   // '*' can act as ')'
        maxOpen++;  // '*' can act as '('
      }
      if (maxOpen < 0) {   // Too many closing brackets
        return false;
      }
      if (minOpen < 0) {  // minOpen should never be negative
        minOpen = 0;
      }
    }
    return minOpen == 0;  // Expression is valid only if all brackets can be balanced
  }

  public static void main(String[] args) {
    System.out.println(checkValidString(")("));
    System.out.println(checkValidString("(*"));
    System.out.println(checkValidString("(()())"));
    System.out.println(checkValidString("(***)"));
    System.out.println(checkValidString("())()"));
  }
}
