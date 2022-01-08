package trees;

import static java.lang.Integer.max;

public class MaxDistanceBetweenAnyNodes {

    private static int max_dist = Integer.MIN_VALUE;

    private static int getMaxDist(Node root) {
        if (root == null) {
            return 0;
        }
        int lH = getMaxDist(root.left);
        int rH = getMaxDist(root.right);
        max_dist = max(max_dist, lH + rH);
        return max(lH, rH) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(6);
        root.left.left.left.right = new Node(7);
        root.left.left.left.right.left = new Node(17);
        root.left.left.left.right.left.left = new Node(27);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.left.right.right.right = new Node(25);
        getMaxDist(root);
        System.out.println(max_dist);
    }
}
