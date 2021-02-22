package trees;

import java.util.Stack;

public class InorderTreeTraversal {

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.num);
            inorder(root.right);
        }
    }

    public static void inorderWithoutRecursion(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                System.out.println(root.num);
                root = root.right;
            }
        }
    }
}
