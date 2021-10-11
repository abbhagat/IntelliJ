package trees;

public class SearchBT {

    public static boolean searchBT(Node root, Node node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return searchBT(root.left, node) || searchBT(root.right, node);
    }

    public static void main(String[] args) {

    }
}
