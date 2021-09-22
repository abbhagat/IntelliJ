package trees;

import static trees.CreateBST.createBST;

public class PrintAllLeafNodesOfABinaryTree {

    private static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            if (root.left == null && root.right == null) {
                System.out.println(root.num);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {50, 25, 100, 10, 30, 90, 120};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        postOrder(root);
    }
}
