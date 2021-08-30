package trees;

import static java.lang.Math.max;

public class TreeHeight {

    public static int treeHeight(Node root) {
        return null == root ? -1 : max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}
