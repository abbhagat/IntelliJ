package trees;

public class TreeHeight {

    private int lHeight, rHeight;

    private void height(Node root) {
        if (root != null) {
            if (root.left != null) {
                lHeight++;
                height(root.left);
            }
            if (root.right != null) {
                rHeight++;
                height(root.right);
            }
        }
    }

    public int treeHeight(Node root) {
        height(root);
        return lHeight > rHeight ? lHeight : rHeight;
    }
}
