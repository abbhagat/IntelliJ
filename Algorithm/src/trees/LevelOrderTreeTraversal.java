package trees;

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
}
