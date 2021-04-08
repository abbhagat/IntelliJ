package trees;

import java.util.Stack;

public class TreeTraversal {

    public static void inorder(BST root) {
        if (null != root) {
            inorder(root.left);
            System.out.print(root.num + " ");
            inorder(root.right);
        }
    }

    public static void preorder(BST root) {
        if (null != root) {
            System.out.print(root.num + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(BST root) {
        if (null != root) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.num + " ");
        }
    }

    public static void preOrderWithoutRecursion(BST root) {
        Stack<BST> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BST current = stack.pop();
            System.out.print(current.num + " ");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void postOrderWithoutRecursion(BST root) {
        Stack<BST> stack = new Stack<>();
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

    public static void inOrderWithoutRecursion(BST root) {
        Stack<BST> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {    /* Reach the left most BST of the curr BST */
                stack.push(root);    /* place pointer to a tree BST on the stack before traversing the BST's left subtree */
                root = root.left;
            }
            root = stack.pop();     /* Current root must be NULL at this point */
            System.out.print(root.num + " ");
            root = root.right;     /* we have visited the BST and its left subtree.Now, it's right subtree's turn */
        }
    }
}
