package trees;

public class IterativeSearchBST {

    BST searchBST(BST root, int num) {
        BST node = null;
        while (root != null) {
            if (root.num == num) {
                return root;
            }
            root = (num < root.left.num) ? root.left : root.right;
        }
        return node;
    }
}
