package trees;

import static trees.TreeTraversal.inorder;

public class PopulateNextRightPointer {

    private static void connect(Node root) {
        while (root != null && root.left != null) {
            Node curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.right = curr.right;
                }
                if (curr.right != null) {
                    curr.right.right = curr.right.left;
                }
                curr = curr.right;
            }
            root = root.left;
        }
    }

    public static void main(String[] args) {
        Node root           = new Node(1);
        root.left           = new Node(2);
        root.right          = new Node(3);
        root.left.left      = new Node(4);
        root.left.right     = new Node(5);
        root.left.left.left = new Node(6);
        inorder(root);
        connect(root);
        System.out.println();
        inorder(root);
    }
}
