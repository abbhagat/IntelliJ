package trees;

import static trees.TreeHeight.height;

public class TreeHeightOfEachNode {

    public static int heightOfEachNode(Node root) {
        return root == null ? 0 : height(root) + heightOfEachNode(root.left) + heightOfEachNode(root.right);
    }

    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        Node root = null;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for (int x : a) {
            root = BT.createBT(x, root);
        }
        heightOfEachNode(root);
    }
}
