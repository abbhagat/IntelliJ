package trees;

import static trees.CreateBST.createBST;
import static trees.TreeTraversal.inorder;

public class DeleteLastNodeInBinaryTree {

    public static void main(String[] args) {
        int[] a = {6, 15, 4, 1, 2, 12, 30};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        inorder(root);
        System.out.println();
        root = deleteLastNode(root);
        inorder(root);
        System.out.println();
    }

    private static Node deleteLastNode(Node root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return null;
            }
            root.left = deleteLastNode(root.left);
            root.right = deleteLastNode(root.right);
        }
        return root;
    }

}
