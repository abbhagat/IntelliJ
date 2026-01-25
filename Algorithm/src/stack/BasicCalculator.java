package stack;

import java.util.Stack;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class BasicCalculator {

  private static int calculate(String exp, int index) {
    Stack<Integer> stack = new Stack<>();
    int n = 0;
    char sign = '+';
    for(int i = index; i < exp.length(); i++) {
      char c = exp.charAt(i);
      if (Character.isDigit(c)) {
        n = n * 10 + (c - '0');
      }
      if (c == '(') {
        i++;                      // skip '('
        n = calculate(exp, i);   // evaluate inside parentheses
      }
      if (!Character.isDigit(c) && c != ' ' || i == exp.length() - 1) {
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
    }
    return stack.stream().mapToInt(Integer::intValue).sum();
  }

  public static void main(String[] args) {
    System.out.println(calculate("3 + 2 * 2", 0));
    System.out.println(calculate("35 + 24 * 20", 0));
    System.out.println(calculate("3/2", 0));
    System.out.println(calculate(" 3 + 5 / 2", 0));
    System.out.println(calculate("1 + 1", 0));
    System.out.println(calculate("2 - 1 + 2", 0));
    System.out.println(calculate("1 + (4 + 5 + 2) - 3 + (6 + 8)", 0));
  }
}
