package trees;

import static trees.CreateBST.createBST;

public class LevelOrderTreeTraversal {

    private static TreeHeight th = new TreeHeight();

    public static void levelOrderTreeTraversal(Node root) {
        int treeHeight = th.treeHeight(root);
        for (int i = 0; i <= treeHeight; i++) {
            printLevelOrder(root, i);
        }
    }

    public static void printLevelOrder(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            System.out.print(root.num + " ");
        }
        if (level > 0) {
            printLevelOrder(root.left,  level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int x : a) {
            root = createBST(root, x);
        }
        System.out.println("Level Order Or BFS Traversal : ");
        levelOrderTreeTraversal(root);
    }
}
