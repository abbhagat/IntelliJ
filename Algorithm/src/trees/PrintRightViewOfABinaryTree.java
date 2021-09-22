package trees;

import static trees.CreateBST.createBST;

public class PrintRightViewOfABinaryTree {

    private static int max_level = 0;

    private static void printRightView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (max_level < level) {
            System.out.print(" " + root.num);
            max_level = level;
        }
        printRightView(root.right, level + 1);
        printRightView(root.left , level + 1);
    }

    public static void main(String args[]) {
        int[] a = {50, 25, 100, 10, 30, 90, 120, 27, 35};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        printRightView(root, 1);
    }
}
