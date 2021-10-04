package trees;

import static java.lang.Integer.max;
import static trees.TreeHeight.treeHeight;

public class BinaryTreeDiameter {

    private static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return max(leftHeight + rightHeight + 1, max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("The diameter of given binary tree is : " + diameter(root));
    }
}
