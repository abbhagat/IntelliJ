package trees;

public class TreeHeight {

    private static int leftHeight, rightHeight;

    public static int treeHeight(Node root) {
        calculateTreeHeight(root);
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    private static void calculateTreeHeight(Node root) {
        if (root != null) {
            if (root.left != null) {
                leftHeight++;
                calculateTreeHeight(root.left);
            }
            if (root.right != null) {
                rightHeight++;
                calculateTreeHeight(root.right);
            }
        }
    }
}
