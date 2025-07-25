package trees;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(n)
// Auxiliary Space: O(n)
public class TreeHeightWithoutRecursion {

    private static int treeHeight(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int height = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                height++;
            }
            if (node != null) {
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
        return height;
    }

    public static void main(String[] args) {
         /*
                      1
                  /      \
                 2        3
               /   \       \
              4     5       6
                   / \      \
                  7  8       9
                              \
                              10
         */
        Node root              = new Node(1);
        root.left              = new Node(2);
        root.right             = new Node(3);
        root.left.left         = new Node(4);
        root.left.right        = new Node(5);
        root.right.right       = new Node(6);
        root.left.right.left   = new Node(7);
        root.left.right.right  = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Tree Height " + treeHeight(root));
    }
}
