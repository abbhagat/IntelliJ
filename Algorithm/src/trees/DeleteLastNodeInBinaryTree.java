package trees;

import static trees.CreateBST.createBST;
import static trees.TreeTraversal.inorder;

public class DeleteLastNodeInBinaryTree {

    public static void main(String[] args) {
        int[] a = {6, 15, 4, 1, 2};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        inorder(root);
        System.out.println();
        //root = deleteLastNodeInBinaryTree(root);
        root = deleteLastNode(root);
        inorder(root);
        System.out.println();
    }


    private static Node deleteLastNodeInBinaryTree(Node root) {
        int treeHeight = new TreeHeight().treeHeight(root);
        for (int i = 0; i <= treeHeight; i++) {
            root = deleteLeafNode(root, i);
        }
        return root;
    }

    private static Node deleteLastNode(Node root) {
        if (root != null) {
            if (root.left == root.right & root.left == null) {
                return null;
            }
            root.left = deleteLastNode(root.left);
            root.right = deleteLastNode(root.right);
        }
        return root;
    }

    private static Node deleteLeafNode(Node root, int i) {
        if (null == root) {
            return root;
        }
        if (i == 0) {
            if (null == root.left && null == root.right) {
                return null;
            }
        }
        if (i > 0) {
            root.left = deleteLeafNode(root.left, i - 1);
            root.right = deleteLeafNode(root.right, i - 1);
        }
        return root;
    }
}
