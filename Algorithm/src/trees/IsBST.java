package trees;

public class IsBST {
    public static final boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.num < min || root.num > max) {
            return false;
        }
        return isBST(root.left, min, root.num - 1) && isBST(root.right, root.num + 1, max);
    }
}
