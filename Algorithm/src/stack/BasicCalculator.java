package stack;

import java.util.Stack;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class BasicCalculator {

  private static int calculate(String exp, int[] idx) {
    Stack<Integer> stack = new Stack<>();
    int n = 0;
    char sign = '+';
    while (idx[0] < exp.length()) {
      char c = exp.charAt(idx[0]);
      if (Character.isDigit(c)) {
        n = n * 10 + (c - '0');
      }
      if (c == '(') {
        idx[0]++;                     // skip '('
        n = calculate(exp, idx);   // evaluate inside parentheses
      }
      if (!Character.isDigit(c) && c != ' ' || idx[0] == exp.length() - 1) {
        switch (sign) {
          case '+' -> stack.push(n);
          case '-' -> stack.push(-n);
          case '*' -> stack.push(stack.pop() * n);
          case '/' -> stack.push(stack.pop() / n);
        }
        sign = c;
        n = 0;
      }
      if (c == ')') {
        break; // end of current sub-expression
      }
      idx[0]++;
    }
    return stack.stream().mapToInt(Integer::intValue).sum();
  }

  public static void main(String[] args) {
    System.out.println(calculate("3 + 2 * 2",                     new int[]{0}));
    System.out.println(calculate("35 + 24 * 20",                  new int[]{0}));
    System.out.println(calculate("3/2",                           new int[]{0}));
    System.out.println(calculate(" 3 + 5 / 2",                    new int[]{0}));
    System.out.println(calculate("1 + 1",                         new int[]{0}));
    System.out.println(calculate("2 - 1 + 2",                     new int[]{0}));
    System.out.println(calculate("1 + (4 + 5 + 2) - 3 + (6 + 8)", new int[]{0}));
  }
}
