package trees;

import static trees.TreeTraversal.*;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        Node root = null;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int x : a) {
            root = BT.createBT(x, root);
        }
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
    }
}
