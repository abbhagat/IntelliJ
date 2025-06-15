package leetcodes;

import java.util.Stack;

/**
Given a string str that consists of lowercase English letters and brackets.
The task is to reverse the substrings in each pair of matching parentheses, starting from the innermost one.
The result should not contain any brackets.
Examples:
Input: str = "(skeeg(for)skeeg)" Output: geeksforgeeks
Input: str = "((ng)ipm(ca))"     Output: camping
*/

// Time  Complexity: O(n)
// Space Complexity: O(n)
public class ReverseSubstringsBetweenParenthesis {

    private static StringBuilder reverseParentheses(String str) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(sb);
                sb = new StringBuilder();
            } else if (c == ')') {
                sb.reverse();
                sb = stack.pop().append(sb);
            } else {
                sb.append(c);
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("((ng)ipm(ca))"));
        System.out.println(reverseParentheses("(skeeg(for)skeeg)"));
    }
}
