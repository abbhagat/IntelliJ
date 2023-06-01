package trees;

import static trees.TreeTraversal.inorder;

// Time Complexity: O(h)

public class DeleteNodeFromBST {

    private static Node deleteNodeFromBST(Node root, int num) {
        if (root == null) {
            return null;
        }
        if (num < root.num) {
            root.left = deleteNodeFromBST(root.left, num);
        } else if (num > root.num) {
            root.right = deleteNodeFromBST(root.right, num);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node temp = minValueNode(root.right);
            root.num = temp.num;
            root.right = deleteNodeFromBST(root.right, temp.num);
        }
        return root;
    }

    private static Node minValueNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String... args) {
        Node root           = new Node(2);
        root.left           = new Node(1);
        root.right          = new Node(3);
        inorder(root);
        System.out.println();
        root = deleteNodeFromBST(root, 2);
        inorder(root);
        System.out.println();
    }
}
