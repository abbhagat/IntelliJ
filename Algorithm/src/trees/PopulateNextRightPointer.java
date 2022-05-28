package trees;

import static trees.TreeTraversal.inorder;

public class PopulateNextRightPointer {

    private static void connect(Node root) {
        if (root == null) {
            return;
        }
        Node pre = root, curr;
        while (pre.left != null) {
            curr = pre;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.right = curr.right;
                }
                if (curr.right != null) {
                    curr.right.right = curr.right.left;
                }
                curr = curr.right;
            }
            pre = pre.left;
        }
    }

    public static void main(String[] args) {
        Node root           = new Node(1);
        root.left           = new Node(2);
        root.right          = new Node(3);
        root.left.left      = new Node(4);
        root.left.right     = new Node(5);
        root.left.left.left = new Node(7);
        inorder(root);
        connect(root);
        System.out.println();
        inorder(root);
    }
}
