package trees;

import java.util.Stack;

public class PreOrderTreeTraversal {

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.num);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void preOrderWithoutRecursion(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.num);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }
}
