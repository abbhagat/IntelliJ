package stack;

import java.util.Stack;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class BasicCalculator {

  private static int index; 

  private static int calculate(String exp) {
    Stack<Integer> stack = new Stack<>();
    int n = 0;
    char sign = '+';
    while (index < exp.length()) {
      char c = exp.charAt(index);
      if (Character.isDigit(c)) {
        n = n * 10 + (c - '0');
      }
      if (c == '(') {
        index++;               // skip '('
        n = calculate(exp);   // evaluate inside parentheses
      }
      if (!Character.isDigit(c) && c != ' ' || index == exp.length() - 1) {
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
      index++;
    }
    return stack.stream().mapToInt(Integer::intValue).sum();
  }

  public static void main(String[] args) {
    index = 0;
    System.out.println(calculate("3 + 2 * 2"));
    index = 0;
    System.out.println(calculate("35 + 24 * 20"));
    index = 0;
    System.out.println(calculate("3/2"));
    index = 0;
    System.out.println(calculate(" 3 + 5 / 2"));
    index = 0;
    System.out.println(calculate("1 + 1"));
    index = 0;
    System.out.println(calculate("2 - 1 + 2"));
    index = 0;
    System.out.println(calculate("1 + (4 + 5 + 2) - 3 + (6 + 8)"));
  }
}
