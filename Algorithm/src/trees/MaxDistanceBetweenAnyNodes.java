package trees;

import static java.lang.Integer.max;

public class MaxDistanceBetweenAnyNodes {

    private static int max_sum = Integer.MIN_VALUE;

    public static int height(Node root) {
        int leftHeight = 0, rightHeight = 0;
        if (root == null) {
            return -1;
        }
        if (root.left != null) {
            leftHeight = height(root.left) + 1;

        }
        if (root.right != null) {
            rightHeight = height(root.right) + 1;

        }
        return max(max_sum, leftHeight + rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(6);
        root.left.left.left.right = new Node(7);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        System.out.println(height(root) - 1);
    }
}
