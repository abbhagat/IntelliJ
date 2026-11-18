package stack;

import java.util.Stack;

// Time  Complexity - O(n)
// Space Complexity - O(n)
public class BalancedBracket {

  private static boolean isBalanced(String exp) {
    Stack<Character> stack = new Stack<>();
    for (char c : exp.toCharArray()) {
      if (c == '{' || c == '(' || c == '[') {
        stack.push(c);
      }
      if ((c == '}' || c == ')' || c == ']') && (stack.isEmpty() || !isMatchingPair(stack.pop(), c))) {
        return false;
      }
    }
    return stack.isEmpty();
  }

  private static boolean isMatchingPair(char x, char y) {
    return x == '(' && y == ')' || x == '{' && y == '}' || x == '[' && y == ']';
  }

  public static void main(String[] args) {
    System.out.println(isBalanced("]"));
    System.out.println(isBalanced("[]"));
    System.out.println(isBalanced("(())"));
    System.out.println(isBalanced("{()}"));
  }

}
