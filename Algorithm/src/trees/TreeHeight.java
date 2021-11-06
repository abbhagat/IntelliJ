package trees;

import static java.lang.Math.max;

public class TreeHeight {

    public static int treeHeight(Node root) {
        return null == root ? -1 : max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }else{
            int leftHeight  = height(root.left);
            int rightHeight = height(root.right);
            int height = leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
            return height;
        }
    }

    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        Node root = null;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int x : a) {
            root = BT.createBT(x, root);
        }
        System.out.println("\nTree Height :" + treeHeight(root));
        System.out.println("\nTree Height :" + height(root));
        System.out.println("\nTree Height :" + treeHeight(null));
        System.out.println("\nTree Height :" + height(null));
    }
}
