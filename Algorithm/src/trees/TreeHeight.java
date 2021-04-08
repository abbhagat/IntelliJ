package trees;

public class TreeHeight {

    int lHeight, rHeight;

    void height(BST root) {
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

    int treeHeight(BST root) {
        height(root);
        return lHeight > rHeight ? lHeight : rHeight;
    }
}
