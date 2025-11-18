package stack;

import java.util.Stack;

public class BasicCalculator {

  private static int calculate(String exp) {
    int result = 0, sign = 1, n = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(sign);
    for (char c : exp.toCharArray()) {
      if (Character.isDigit(c)) {
        n = n * 10 + c - '0';
      } else if (c == '+' || c == '-') {
        result += sign * n;
        sign = stack.peek() * (c == '+' ? 1 : -1);
        n = 0;
      } else if (c == '(') {
        stack.push(sign);
      } else if (c == ')') {
        stack.pop();
      }
    }
    result += sign * n;
    return result;
  }

  public static void main(String[] args) {
    System.out.println(calculate("1 + 1"));
    System.out.println(calculate("2 - 1 + 2"));
    System.out.println(calculate("1 + (4 + 5 + 2) - 3 + (6 + 8)"));
  }
}
