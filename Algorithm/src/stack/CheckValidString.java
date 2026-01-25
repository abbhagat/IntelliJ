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
 * Furthermore, we can prove these states always form a contiguous interval.
 * Thus, we only need to know the left and right bounds of this interval.
 * That is, we would keep those intermediate states described above as [lo, hi] = [1, 1], [0, 2], [0, 3], [0, 4], [0, 3].
 * Algorithm
 * Let low, high respectively be the smallest and largest possible number of open left brackets after processing the current character in the string.
 * If we encounter a left bracket (c == '('), then low++, otherwise we could write a right bracket, so low--.
 * If we encounter what can be a left bracket (c != ')'), then hi++, otherwise we must write a right bracket, so hi--.
 * If hi < 0, then the current prefix can't be made valid no matter what our choices are.
 * Also, we can never have less than 0 open left brackets. At the end, we should check that we can have exactly 0 open left brackets.
 */

public class CheckValidString {

  public static boolean checkValidString(String exp) {
    int open = 0, close = 0;
    for (char c : exp.toCharArray()) {
      if (c == '(') {
        open++;
      } else if (c == '*') {
        close++;
      } else if (c == ')' && open > 0) {
        open--;
      } else if (c == ')') {
        return false;
      }
    }
    return open <= close;
  }

  public static void main(String[] args) {
    System.out.println(checkValidString(")("));
    System.out.println(checkValidString("(*"));
    System.out.println(checkValidString("(()())"));
    System.out.println(checkValidString("(***)"));
    System.out.println(checkValidString("())()"));
  }
}
