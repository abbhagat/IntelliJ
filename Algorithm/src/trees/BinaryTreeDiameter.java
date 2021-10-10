package trees;


// Time Complexity: O(n)

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
        int leftDiameter  = diameter(root.left, lH);
        int rightDiameter = diameter(root.right, rH);
        height.h = Math.max(lH.h, rH.h) + 1;
        return max(lH.h + rH.h + 1, max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("The diameter of given binary tree is : " + diameter(root, new Height()));
    }
}
