package stack;

import java.util.Stack;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class BasicCalculator {

  private static int index = 0;

  public static int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char sign = '+';
    while (index < s.length()) {
      char c = s.charAt(index);
      if (Character.isDigit(c)) {
        num = num * 10 + (c - '0');
      }
      if (c == '(') {
        index++;                      // skip '('
        num = calculate(s);           // evaluate inside parentheses
      }
      if (!Character.isDigit(c) && c != ' ' || index == s.length() - 1) {
        switch (sign) {
          case '+' -> stack.push(num);
          case '-' -> stack.push(-num);
          case '*' -> stack.push(stack.pop() * num);
          case '/' -> stack.push(stack.pop() / num);
        }
        sign = c;
        num = 0;
      }
      if (c == ')') {
        break;  // end of this recursion level
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
