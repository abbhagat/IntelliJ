package trees;

import java.util.Stack;

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

    public static void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.num + " ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public static void postOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
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

    public static void inOrder(Node root) {
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
         /*
                       4
                      / \
                     2   6
                    / \  /\
                   1  3  5 7
         */
        Node root           = new Node(4);
        root.left           = new Node(2);
        root.right          = new Node(6);
        root.left.left      = new Node(1);
        root.left.right     = new Node(3);
        root.right.left     = new Node(5);
        root.right.right    = new Node(7);
        inorder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }
}
