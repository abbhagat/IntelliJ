package stack;

import java.util.Stack;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class BasicCalculator {

  private static int i = 0;

  public static int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int n = 0;
    char sign = '+';
    while (i < s.length()) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        n = n * 10 + (c - '0');
      }
      if (c == '(') {
        i++;                      // skip '('
        n = calculate(s);        // evaluate inside parentheses
      }
      if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
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
        break;  // end of this recursion level
      }
      i++;
    }
    return stack.stream().mapToInt(Integer::intValue).sum();  // return the sum of all the elements in stack
  }

  public static void main(String[] args) {
    i = 0;
    System.out.println(calculate("3 + 2 * 2"));
    i = 0;
    System.out.println(calculate("35 + 24 * 20"));
    i = 0;
    System.out.println(calculate("3/2"));
    i = 0;
    System.out.println(calculate(" 3 + 5 / 2"));
    i = 0;
    System.out.println(calculate("1 + 1"));
    i = 0;
    System.out.println(calculate("2 - 1 + 2"));
    i = 0;
    System.out.println(calculate("1 + (4 + 5 + 2) - 3 + (6 + 8)"));
  }
}
