package stack;

import java.util.Stack;

// Time Complexity: O(n)
public class SimplifyPath {

  private static void simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    for (String str : path.split("/")) {
      if (str.isEmpty() || str.equals(".")) {
        continue;
      }
      if (str.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(str);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop())
        .insert(0, "/");
    }
    System.out.println(sb.length() == 0 ? "/" : sb);
  }

  public static void main(String[] args) {
    simplifyPath("/home");
    simplifyPath("/a/./b/../../c/");
    simplifyPath("/a/../../b/../c//.//");
    simplifyPath("/a//b////c/d//././/..");
  }
}
