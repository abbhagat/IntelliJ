package jpmorgan;

import java.util.Stack;

import static util.CommonUtils.printArray;

public class PopulateNextGreaterElements {

  public static void main(String[] args) {
    int[] a = {16, 17, 4, 3, 5, 2};  // [17, 17, 5, 5, 5, -1]
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < a.length; i++) {
      int j = stack.isEmpty() ? 0 : stack.pop();
      while (a[j] < a[i]) {
        a[j] = a[i];
        if (stack.isEmpty()) {
          break;
        }
        j = stack.pop();
      }
      if (a[j] > a[i]) {
        stack.push(j);
      }
      stack.push(i);
    }
    a[a.length - 1] = -1;
    printArray(a);
  }
}
