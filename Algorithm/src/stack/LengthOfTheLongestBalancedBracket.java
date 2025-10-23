package stack;

import java.util.Stack;

import static java.lang.Integer.max;
import static java.lang.Math.abs;

// Time Complexity  - O(n)
// Space Complexity - O(n)
public class LengthOfTheLongestBalancedBracket {

  private static int findLength(String bracket) {
    int max = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    for (int i = 0; i < bracket.length(); i++) {
      if (bracket.charAt(i) == '{') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        }
        max = max(max, abs(i - stack.peek()));
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(findLength("{}}"));
    System.out.println(findLength("{{}}"));
    System.out.println(findLength("{}}{{}}"));
  }
}
