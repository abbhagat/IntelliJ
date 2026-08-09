package stack;

import java.util.ArrayDeque;
import java.util.Deque;

// Time Complexity: O(n)
public class SimplifyPath {

  private static String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    for (String str : path.split("/")) {
      if (str.isEmpty() || str.equals(".")) {
        continue;
      }
      if (str.equals("..") && !stack.isEmpty()) {
        stack.pollLast();    // removes and returns the last element -> Element / null
      } else {
        stack.addLast(str); // Adds str to the end -> boolean
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
