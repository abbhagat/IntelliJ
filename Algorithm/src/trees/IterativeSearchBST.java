package trees;

public class IterativeSearchBST {

    public static Node searchBST(Node root, int num) {
        while (root != null) {
            if (root.num == num) {
                return root;
            }
            root = (num < root.left.num) ? root.left : root.right;
        }
        return null;
    }
}
