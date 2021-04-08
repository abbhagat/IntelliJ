package trees;

public class IsCompleteBT {

    boolean isCompleteBT(BST root) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            return false;
        }
        return (isCompleteBT(root.left) && isCompleteBT(root.right));
    }
}
