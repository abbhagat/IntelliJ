package trees;

import static trees.TreeHeight.treeHeight;

public class LevelOrderTreeTraversal {

    public static void printTree(Node root) {
        for (int i = 1; i <= treeHeight(root); i++) {
            printLevelOrder(root, i);
        }
    }

    private static void printLevelOrder(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.num);
        }
        if (level > 1) {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }
}
