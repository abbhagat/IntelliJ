package trees;

/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
Time Complexity: O(n)
*/

import static java.lang.Integer.max;

public class BinaryTreeDiameter {

    private static int diameter = Integer.MIN_VALUE;

    private static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int lH   = diameter(root.left);
        int rH   = diameter(root.right);
        diameter = max(diameter, lH + rH);
        return Math.max(lH, rH) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        diameter(root);
        System.out.println(diameter);
        System.out.println("Diameter : " + (diameter(root)));
    }
}
