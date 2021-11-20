package trees;

public class IsBinaryTreeHeightBalanced {

    private static boolean isBinaryTreeHeightBalanced(Node root) {
        return maxHeight(root) != -1;
    }

    private static int maxHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int lH  = maxHeight(root.left);
        int rH  = maxHeight(root.right);
        if (lH == -1 || rH == -1 || Math.abs(lH - rH) > 1) {
            return -1;
        }
        return Math.max(lH, rH) + 1;
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
