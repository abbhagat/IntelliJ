package stack;

import java.util.Stack;

import static java.lang.Integer.max;
import static java.lang.Math.abs;

public class LengthOfTheLongestBalancedBracket {

    private static int findLength(String bracket) {
        int maxLength = Integer.MIN_VALUE;
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
                maxLength = max(maxLength, abs(i - stack.peek()));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("{}}"));
        System.out.println(findLength("{{}}"));
        System.out.println(findLength("{}}{{}}"));
    }
}
