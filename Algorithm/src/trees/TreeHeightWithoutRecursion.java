package trees;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(n)
// Auxiliary Space: O(n)
public class TreeHeightWithoutRecursion {

    private static int treeHeight(Node root) {
        int height = -1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
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
            }else if (!q.isEmpty()) {
                q.add(null);
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Node root           = new Node(1);
        root.left           = new Node(2);
        root.right          = new Node(3);
        root.left.left      = new Node(4);
        root.left.right     = new Node(5);
        System.out.println("Tree Height :" + treeHeight(root));
    }
}
