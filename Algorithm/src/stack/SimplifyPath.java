package stack;

import java.util.ArrayDeque;
import java.util.Deque;

// Time Complexity: O(n)
public class SimplifyPath {

  private static String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    for (String s : path.split("/")) {
      if (s.isEmpty() || s.equals(".")) {
        continue;
      }
      if (s.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pollLast();   // removes and returns the last element -> Element / null
        }
      } else {
        stack.addLast(s);    // Adds s to the end -> boolean
      }
    }
    return "/" + String.join("/", stack);
  }

  public static void main(String[] args) {
    System.out.println(simplifyPath("/home"));
    System.out.println(simplifyPath("/a/./b/../../c/"));
    System.out.println(simplifyPath("/a/../../b/../c//.//"));
    System.out.println(simplifyPath("/a//b////c/d//././/.."));
  }
}
