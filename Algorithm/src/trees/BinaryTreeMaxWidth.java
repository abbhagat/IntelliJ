package trees;

import static trees.TreeHeight.treeHeight;
/*

        /*   Constructed Binary tree is:
        1
      /   \
    2      3
  /  \      \
 4    5      8
           /   \
          6     7

 */

public class BinaryTreeMaxWidth {

    private static int width = 0;

    private static int maxWidth(Node root) {
        int maxWidth = Integer.MIN_VALUE;
        int height = treeHeight(root);
        for (int i = 0; i <= height; i++) {
            levelOrderTraversal(root, i);
            System.out.println("Width of Level " + i + " -> " + width);
            maxWidth = Math.max(maxWidth, width);
            width = 0;
        }
        return maxWidth;
    }

    private static void levelOrderTraversal(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            width++;
            return;
        }
        levelOrderTraversal(root.left,  level - 1);
        levelOrderTraversal(root.right, level - 1);
    }

    public static void main(String[] args) {
        Node root              = new Node(1);
        root.left              = new Node(2);
        root.right             = new Node(3);
        root.left.left         = new Node(4);
        root.left.right        = new Node(5);
        root.right.left        = new Node(7);
        root.right.right       = new Node(8);
        root.right.right.left  = new Node(6);
        root.right.right.right = new Node(9);
        System.out.println("Maximum width = " + maxWidth(root));
    }
}

