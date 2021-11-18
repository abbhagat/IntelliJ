package trees;

import static trees.TreeHeight.treeHeight;

public class SpiralOrderTreeTraversal {

    public static void levelOrderTreeTraversal(Node root) {
        int treeHeight = treeHeight(root);
        boolean flag = true;
        for (int i = 0; i <= treeHeight; i++) {
            printLevelOrder(root, i, flag);
            flag = !flag;
        }
    }

    public static void printLevelOrder(Node root, int level, boolean flag) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            System.out.print(root.num + " ");
            return;
        }
        if (flag) {
            printLevelOrder(root.left,  level - 1, true);
            printLevelOrder(root.right, level - 1, true);
        } else {
            printLevelOrder(root.right, level - 1, false);
            printLevelOrder(root.left,  level - 1, false);
        }
    }

    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        Node root = null;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int x : a) {
            root = BT.createBT(x, root);
        }
        System.out.println("Level Order Or BFS Traversal : ");
        levelOrderTreeTraversal(root);
    }
}
