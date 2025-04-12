package trees;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.max;
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

// Time Complexity : O(n)
// Space Complexity: O(2^h)
public class BinaryTreeMaxWidth {

    private static int findMaxWidth(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int width = 0, maxWidth = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                maxWidth = max(maxWidth, width);
                width = 0;
            }
            if (node != null) {
                width++;
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
        System.out.println("Maximum width = " + findMaxWidth(root));
    }
}
