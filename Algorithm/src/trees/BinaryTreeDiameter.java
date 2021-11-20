package trees;

/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
Time Complexity: O(n)

*/


import static java.lang.Integer.max;

class Height {
    int h;
}

public class BinaryTreeDiameter {

    private static int diameter(Node root, Height height) {
        Height lH = new Height();
        Height rH = new Height();
        if (root == null) {
            height.h = 0;
            return 0;
        }
        int leftDiameter  = diameter(root.left,  lH);
        int rightDiameter = diameter(root.right, rH);
        height.h = max(lH.h, rH.h) + 1;
        return max(lH.h + rH.h + 1, max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("The diameter of given binary tree is : " + (diameter(root, new Height()) - 1));
    }
}
