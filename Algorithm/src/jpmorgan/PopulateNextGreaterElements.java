package jpmorgan;

import java.util.Stack;

import static util.CommonUtils.printArray;

public class PopulateNextGreaterElements {

    public static void main(String[] args) {
        int[] a = {16, 17, 4, 3, 5, 2};  // 17, 5, 5, 5, 2, -1
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < a.length; i++) {
            int index = stack.isEmpty() ? 0 : stack.pop();
            while (a[index] < a[i]) {
                a[index] = a[i];
                if (stack.isEmpty()) {
                    break;
                }
                index = stack.pop();
            }
            if (a[index] > a[i]) {
                stack.push(index);
            }
            stack.push(i);
        }
        a[a.length - 1] = -1;
        printArray(a);
    }
}
