package trees;

import java.util.Stack;

import static trees.BinaryTree.createBT;

public class TreeTraversal {

    public static void inorder(Node root) {
        if (null != root) {
            inorder(root.left);
            System.out.print(root.num + " ");
            inorder(root.right);
        }
    }

    public static void preorder(Node root) {
        if (null != root) {
            System.out.print(root.num + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (null != root) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.num + " ");
        }
    }

    public static void preOrderWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.num + " ");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void postOrderWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if (stack.empty()) {
                return;
            }
            root = stack.pop();
            if (!stack.empty() && stack.peek() == root) {
                root = root.right;
            } else {
                System.out.print(root.num + " ");
                root = null;
            }
        }
    }

    public static void inOrderWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.num + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int x : a) {
            root = createBT(x, root);
        }
        inorder(root);
        System.out.println();
        inOrderWithoutRecursion(root);
        System.out.println();
        preorder(root);
        System.out.println();
        preOrderWithoutRecursion(root);
        System.out.println();
        postorder(root);
        System.out.println();
        postOrderWithoutRecursion(root);
        System.out.println();
    }
}
