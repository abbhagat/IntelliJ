package stack;

import java.util.Stack;

public class BalancedBracket {

    public static void main(String[] args) {
        System.out.println(areParenthesisBalanced("]".toCharArray())    ? "Balanced" : "Not Balanced");
        System.out.println(areParenthesisBalanced("[]".toCharArray())   ? "Balanced" : "Not Balanced");
        System.out.println(areParenthesisBalanced("(())".toCharArray()) ? "Balanced" : "Not Balanced");
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
        return s.isEmpty() ? true : false;
    }

    private static boolean isMatchingPair(char c1, char c2) {
        if ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']')) {
            return true;
        }
        return false;
    }
}
