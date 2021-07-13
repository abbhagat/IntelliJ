package stack;

import java.util.Stack;

public class CheckValidString {

    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(' || x == '*') {
                stack.push(x);
            } else {
                if (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c == '*' || c == '(') {
                        continue;
                    }
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() == ')') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = ")(";
        System.out.println(checkValidString(s));
    }
}
