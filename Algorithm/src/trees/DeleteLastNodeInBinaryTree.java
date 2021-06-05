package trees;

import static trees.BinaryTree.createBT;
import static trees.TreeTraversal.inorder;

public class DeleteLastNodeInBinaryTree {

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 1, 2, 5};
        Node root = null;
        for (int x : a) {
            root = createBT(x, root);
        }
        inorder(root);
        System.out.println();
        deleteLastNodeInBinaryTree(root);
        inorder(root);
        System.out.println();
    }

    private static void deleteLastNodeInBinaryTree(Node root) {
        for (int i = 1; i <= new TreeHeight().treeHeight(root); i++) {
            deleteLeafNode(root, i);
        }
    }

    private static void deleteLeafNode(Node root, int i) {
        if (null == root) {
            return;
        }
        if (i == 1) {
            if (null == root.left && null == root.right) {
                root = null;
            }
        }
        if (i > 1) {
            deleteLeafNode(root.left, i - 1);
            deleteLeafNode(root.right, i - 1);
        }
    }
}
