package trees;

import static trees.TreeTraversal.inorder;

public class DeleteNodeFromBST {

    private static Node deleteNodeFromBST(Node root, int num) {
        if (null == root) {
            return null;
        }
        if (num < root.num) {
            root.left = deleteNodeFromBST(root.left, num);
        } else if (num > root.num) {
            root.right = deleteNodeFromBST(root.right, num);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
                return null;
            } else if (root.left == null) {
                Node temp = root.right;
                root = null;
                return temp;
            } else if (root.right == null) {
                Node temp = root.left;
                root = null;
                return temp;
            } else {
                Node temp = minValueNode(root.right);
                root.num = temp.num;
                root.right = deleteNodeFromBST(root.right, temp.num);
            }
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
        int[] a = {30, 10, 50, 5, 20, 40, 60};
        Node root = null;
        CreateBST bst = new CreateBST();
        for (int i = 0; i < a.length; i++) {
            root = bst.createBST(root, a[i]);
        }
        inorder(root);
        System.out.println();
        root = deleteNodeFromBST(root, 40);
        inorder(root);
        System.out.println();
    }
}
