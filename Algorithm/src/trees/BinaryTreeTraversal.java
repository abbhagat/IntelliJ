package trees;

import static trees.LevelOrderTreeTraversal.levelOrderTreeTraversal;
import static trees.TreeTraversal.*;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        Node root = null;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int x : a) {
            root = BT.createBT(x, root);
        }
        System.out.println("Level Order Or BFS Traversal : ");
        levelOrderTreeTraversal(root);
        System.out.println();
        inorder(root);
        System.out.println();
        inOrderWithoutRecursion(root);
        System.out.println();
        preorder(root);
        System.out.println();
        preOrderWithoutRecursion(root);
        System.out.println();
        postorder(root);
        System.out.println();
        postOrderWithoutRecursion(root);
        System.out.println();
        TreeHeight height = new TreeHeight();
        System.out.println("\nTree Height :" + height.treeHeight(root));
        CreateBST BST = new CreateBST();
        root = null;
        for (int x : a) {
            root = BST.createBST(root, x);
        }
        preorder(root);
        height = new TreeHeight();
        System.out.println("\nTree Height :" + height.treeHeight(root));
    }
}
