package amazon;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] a = {4, 5, 7, 3, 10, 0};
        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            int element = 0;
            if (!stack.isEmpty()) {
                element = stack.pop();
            }
            while (element <= a[i]) {
                System.out.println(element + " " + a[i]);
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
            System.out.println(stack.pop() + " " + "-1");
        }
    }
}
