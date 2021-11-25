package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveInValidBracket {

    private static void removeInvalidParenthesis(String str) {
        if(str.isEmpty()){
            return;
        }
        Set<String> set = new HashSet<>();       // set to ignore already visited string
        Stack<String> stack = new Stack<>();
        stack.push(str);
        set.add(str);
        while (!stack.isEmpty()) {
            str = stack.pop();
            if (isValidString(str)) {
                System.out.println(str);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        String temp = str.substring(0, i) + str.substring(i + 1);  // Removing parenthesis from str
                        if (!set.contains(temp)) {                                //  Pushing into stack if not visited already
                            stack.push(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
    }

    private static boolean isValidString(String str) {   // method returns true if string contains valid parenthesis
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
        removeInvalidParenthesis("()v)");
    }
}
