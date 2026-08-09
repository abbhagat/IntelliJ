package stack;

import java.util.Stack;

// Time Complexity  : O(n)
// Space Complexity : O(n)
public class FindTheLongestBalancedBracketAndItsLength {

  private static void longestBalancedBracketLength(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int max = 0, end = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '{') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          int length = i - stack.peek();
          if (max < length) {
            max = length;
            end = i;
          }
        }
      }
    }
    String str = max > 0 ? s.substring(end - max + 1, end + 1) : "";
    System.out.println(str + ".length() = " + str.length());
  }

  public static void main(String[] args) {
    longestBalancedBracketLength("}{");
    longestBalancedBracketLength("{}}");
    longestBalancedBracketLength("{{}}");
    longestBalancedBracketLength("{}}{{}}");
  }
}
