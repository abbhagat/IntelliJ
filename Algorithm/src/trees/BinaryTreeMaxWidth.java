package trees;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.max;
import static trees.TreeHeight.treeHeight;
/*
Constructed Binary tree is:
                    1
                  /   \
                2      3
              /  \    /  \
             4    5  7    8
                       /   \
                      6     9
 */

// Time Complexity : O(n * 2^h)
// Space Complexity: O(2^h)
public class BinaryTreeMaxWidth {

    private static int width;

    private static int maxWidth(Node root) {
        int maxWidth = Integer.MIN_VALUE;
        int height   = treeHeight(root);
        for (int i = 0; i <= height; i++) {
            levelOrderTraversal(root, i);
            System.out.println("Width of Level " + i + " -> " + width);
            maxWidth = max(maxWidth, width);
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

    private static int findMaxWidth(Node root) {
        int maxWidth = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int n = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                maxWidth = max(maxWidth, n);
                n = 0;
            }
            if (node != null) {
                n++;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else if (!q.isEmpty()) {
                q.add(null);
            }
        }
        return maxWidth;
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
        System.out.println("Maximum width = " + findMaxWidth(root));
    }
}
