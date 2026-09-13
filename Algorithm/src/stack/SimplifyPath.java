package stack;

import java.util.Deque;
import java.util.LinkedList;

// Time Complexity: O(n)
public class SimplifyPath {

  private static String simplifyPath(String path) {
    Deque<String> queue = new LinkedList<>();
    for (String s : path.split("/")) {
      if (s.isEmpty() || s.equals(".")) {
        continue;
      }
      if (s.equals("..")) {
        queue.pollLast();   // removes and returns the last element -> Element / null
      } else {
        queue.addLast(s);   // Adds s to the end -> boolean
      }
    }
    return "/" + String.join("/", queue);
  }

  public static void main(String[] args) {
    System.out.println(simplifyPath("/home"));
    System.out.println(simplifyPath("/a/./b/../../c/"));
    System.out.println(simplifyPath("/a/../../b/../c//.//"));
    System.out.println(simplifyPath("/a//b////c/d//././/.."));
  }
}
