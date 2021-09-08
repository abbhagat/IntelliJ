package geeksforgeeks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveInValidBracket {

    private static void removeInvalidParenthesis(String str) {
        if (str.isEmpty()) {
            return;
        }
        Set<String> set = new HashSet<>();              // set to ignore already visited string
        Stack<String> stack = new Stack<>();
        stack.push(str);
        set.add(str);

        while (!stack.isEmpty()) {
            str = stack.pop();
            if (isValidString(str)) {
                System.out.println(str);
                continue;
            }
            for (int i = 0; i < str.length(); i++) {
                if (!isParenthesis(str.charAt(i))) {
                    continue;
                }
                String temp = str.substring(0, i) + str.substring(i + 1);  // Removing parenthesis from str and pushing into queue,if not visited already
                if (!set.contains(temp)) {
                    stack.push(temp);
                    set.add(temp);
                }
            }
        }
    }

    private static boolean isParenthesis(char c) {  // method checks if character is parenthesis(open or closed)
        return ((c == '(') || (c == ')'));
    }


    private static boolean isValidString(String str) {   // method returns true if string contains valid parenthesis
        int count = 0;
        for (char x : str.toCharArray()) {
            if (x == '(') {
                count++;
            } else if (x == ')') {
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
        removeInvalidParenthesis("()v)");
    }
}

