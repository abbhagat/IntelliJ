package trees;

public class IsBinaryTreeHeightBalanced {

    private static boolean isBinaryTreeHeightBalanced(Node root) {
        return maxHeight(root) != -1;
    }

    private static int maxHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight  = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node root       = new Node(10);
        root.left       = new Node(12);
        root.right      = new Node(15);
        root.left.left  = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        System.out.println(isBinaryTreeHeightBalanced(root) ? "Balanced" : "Not Balanced");
    }
}
