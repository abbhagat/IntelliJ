package trees;

public class IsBST {
    public static final boolean isBST(BST root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.left.num < min || root.right.num > max) {
            return false;
        }
        return isBST(root.left, min, root.num) && isBST(root.right, root.num, max);
    }
}
