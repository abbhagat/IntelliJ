package trees;

public class InvertBinaryTree {

    private static Node invertBT(Node root) {
        if (root != null) {
            Node right = invertBT(root.right);
            Node left  = invertBT(root.left);
            root.left = right;
            root.right = left;
            return root;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
