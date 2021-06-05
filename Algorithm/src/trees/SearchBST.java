package trees;

public class SearchBST {

    Node searchBST(Node root, int num) {
        if (root != null) {
            if (root.num == num) {
                return root;
            } else if (num < root.num) {
                root = searchBST(root.left, num);
            } else {
                root = searchBST(root.right, num);
            }
        }
        return root;
    }
}
