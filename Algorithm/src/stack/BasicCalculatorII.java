package stack;

import java.util.Stack;
import static java.lang.Character.isDigit;

public class BasicCalculatorII {

  public static int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int n = 0;
    char sign = '+';
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (isDigit(c)) {
        n = n * 10 + (c - '0');
      }
      if ((!isDigit(c) && c != ' ') || i == s.length() - 1) {
        switch (sign) {
          case '+' -> stack.push(n);
          case '-' -> stack.push(-n);
          case '*' -> stack.push(stack.pop() * n);
          case '/' -> stack.push(stack.pop() / n);
        }
        sign = c;
        n = 0;
      }
    }
    return stack.stream()
        .mapToInt(Integer::intValue)
        .sum();
  }

  public static void main(String[] args) {
    System.out.println(calculate("3 + 2 * 2"));
    System.out.println(calculate("35 + 24 * 20"));
    System.out.println(calculate("3 / 2"));
    System.out.println(calculate(" 3 + 5 / 2"));
    System.out.println(calculate("1 + 1"));
    System.out.println(calculate("2 - 1 + 2"));
  }
}

