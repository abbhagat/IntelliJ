package trees;

import static java.lang.Integer.max;

public class MaxDistanceBetweenAnyNodes {

    private static int max_sum = Integer.MIN_VALUE;

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }else{
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int height = leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
            return max(max_sum, height);
        }
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
        System.out.println(height(root));
    }
}
