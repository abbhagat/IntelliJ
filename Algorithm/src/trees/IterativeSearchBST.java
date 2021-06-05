package trees;

public class IterativeSearchBST {

    Node searchBST(Node root, int num) {
        Node node = null;
        while (root != null) {
            if (root.num == num) {
                return root;
            }
            root = (num < root.left.num) ? root.left : root.right;
        }
        return node;
    }
}
