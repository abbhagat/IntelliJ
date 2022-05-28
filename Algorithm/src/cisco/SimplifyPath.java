package cisco;

import java.util.Stack;

public class SimplifyPath {

    private static String simplifyPath(String path) {
        if (path.isEmpty() || path.length() == 0) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (s.length() == 0 || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop()).insert(0, "/");
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
