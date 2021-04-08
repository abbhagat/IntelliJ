package trees;

public class TreeMirrorImage {

    BST mirrorImage(BST root) {
        if (root == null) {
            return root;
        }
        BST left = mirrorImage(root.left);
        BST right = mirrorImage(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
