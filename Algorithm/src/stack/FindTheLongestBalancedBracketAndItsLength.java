package stack;

import java.util.Stack;

// Time Complexity  : O(n)
// Space Complexity : O(n)
public class FindTheLongestBalancedBracketAndItsLength {

  private static void longestBalancedBracketLength(String exp) {
    int maxLength = 0, endIndex = -1;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    for (int i = 0; i < exp.length(); i++) {
      if (exp.charAt(i) == '{') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          int length = i - stack.peek();
          if (maxLength < length) {
            maxLength = length;
            endIndex = i;
          }
        }
      }
    }
    String s = maxLength > 0 ? exp.substring(endIndex - maxLength + 1, endIndex + 1) : "";
    System.out.println(s + ".length() = " + s.length());
  }

  public static void main(String[] args) {
    longestBalancedBracketLength("}{");
    longestBalancedBracketLength("{}}");
    longestBalancedBracketLength("{{}}");
    longestBalancedBracketLength("{}}{{}}");
  }
}
