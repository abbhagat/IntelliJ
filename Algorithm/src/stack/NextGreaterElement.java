package stack;

import java.util.Stack;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class NextGreaterElement {

  private static void nextGreaterElement(int[] a) {
    Stack<Integer> stack = new Stack<>();
    stack.push(a[0]);
    for (int i = 1; i < a.length; i++) {
      int element = stack.isEmpty() ? 0 : stack.pop();
      while (element <= a[i]) {
        System.out.println(element + " -> " + a[i]);
        if (stack.isEmpty()) {
          break;
        }
        element = stack.pop();
      }
      if (element > a[i]) {
        stack.push(element);
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
