package stack;

import java.util.Stack;

// Time Complexity  : O(n)
// Space Complexity : O(n)
public class FindTheLongestBalancedBracketAndItsLength {

  private static void longestBalancedBracketLength(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int maxLength = 0, endIndex = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '{') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          int length = i - stack.peek();
          if (maxLength < length) {
            maxLength = length;
            endIndex  = i;
          }
        }
      }
    }
    String str = maxLength > 0 ? s.substring(endIndex - maxLength + 1, endIndex + 1) : "";
    System.out.println(str + ".length() = " + str.length());
  }

  public static void main(String[] args) {
    longestBalancedBracketLength("}{");
    longestBalancedBracketLength("{}}");
    longestBalancedBracketLength("{{}}");
    longestBalancedBracketLength("{}}{{}}");
  }
}
