package stack;

import java.util.Stack;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class NextGreaterElement {

  private static void nextGreaterElement(int[] a) {
    Stack<Integer> stack = new Stack<>();
    stack.push(a[0]);
    for (int i = 1; i < a.length; i++) {
      int n = stack.isEmpty() ? 0 : stack.pop();
      while (n <= a[i]) {
        System.out.println(n + " -> " + a[i]);
        if (stack.isEmpty()) {
          break;
        }
        n = stack.pop();
      }
      if (n > a[i]) {
        stack.push(n);
      }
      stack.push(a[i]);
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop() + " -> " + "-1");
    }
  }

  public static void main(String[] args) {
    nextGreaterElement(new int[]{4, 5, 7, 3, 10, 0});
  }
}
