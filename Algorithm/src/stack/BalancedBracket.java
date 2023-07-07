package stack;

import java.util.Stack;

// Time Complexity - O(n)
public class BalancedBracket {

    public static void main(String[] args) {
        System.out.println(areParenthesisBalanced("]"   .toCharArray()) ? "Balanced" : "Not Balanced");
        System.out.println(areParenthesisBalanced("[]"  .toCharArray()) ? "Balanced" : "Not Balanced");
        System.out.println(areParenthesisBalanced("(())".toCharArray()) ? "Balanced" : "Not Balanced");
        System.out.println(areParenthesisBalanced("{()}".toCharArray()) ? "Balanced" : "Not Balanced");
    }

    private static boolean areParenthesisBalanced(char[] exp) {
        Stack<Character> s = new Stack<>();
        for (char c : exp) {
            if (c == '{' || c == '(' || c == '[') {
                s.push(c);
            }
            if ((c == '}' || c == ')' || c == ']') && (s.isEmpty() || !isMatchingPair(s.pop(), c))) {
                return false;
            }
        }
        return s.isEmpty();
    }

    private static boolean isMatchingPair(char x, char y) {
        return x == '(' && y == ')' || x == '{' && y == '}' || x == '[' && y == ']';
    }
}
