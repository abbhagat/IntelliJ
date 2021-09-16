package trees;

import static trees.CreateBST.createBST;

public class PrintAllNodesAtKDistanceFromRoot {

    private static void printNodes(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            System.out.print(root.num + " ");
        }
        if (level > 0) {
            printNodes(root.left, level - 1);
            printNodes(root.right, level - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 1, 6, 2, 0, 8, 7, 4};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        printNodes(root, 2);
    }
}
