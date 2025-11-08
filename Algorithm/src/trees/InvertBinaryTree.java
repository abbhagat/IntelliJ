package trees;

import static trees.TreeTraversal.inorder;

public class InvertBinaryTree {

    private static Node invertBT(Node root) {
        if (root == null) {
            return null;
        }
        Node right = invertBT(root.right);
        Node left = invertBT(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        inorder(root);
        root = invertBT(root);
        System.out.println();
        inorder(root);
    }
}
