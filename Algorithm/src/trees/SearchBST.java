package trees;

public class SearchBST {

    Node searchBST(Node root, int num) {
        if (root != null) {
            if (root.num == num) {
                return root;
            }
            return num < root.num ? searchBST(root.left, num) : searchBST(root.right, num);
        }
        return root;
    }
}
