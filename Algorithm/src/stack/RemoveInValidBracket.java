package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveInValidBracket {
    private static void removeInvalidParenthesis(String str) {
        Set<String>     set = new HashSet<>();  // set to ignore already visited string
        Stack<String> stack = new Stack<>();
        stack.push(str);
        set.add(str);
        while (!stack.isEmpty()) {
            str = stack.pop();
            if (isValid(str)) {
                System.out.println(str);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        String s = str.substring(0, i) + str.substring(i + 1);  // Removing parenthesis from str
                        if (!set.contains(s)) {  //  Pushing into stack if not visited already
                            stack.push(s);
                            set.add(s);
                        }
                    }
                }
            }
        }
    }

    private static boolean isValid(String str) {   // method returns true if string contains valid parenthesis
        if (str.isEmpty()) {
            return false;
        }
        int count = 0;
        for (char x : str.toCharArray()) {
            if (x == '(') {
                count++;
            }
            if (x == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        removeInvalidParenthesis("()())()");
        System.out.println();
        removeInvalidParenthesis("()v)");
    }
}
