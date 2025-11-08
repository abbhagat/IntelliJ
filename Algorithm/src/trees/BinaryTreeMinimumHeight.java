package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

public class BinaryTreeMinimumHeight {

    public static int minDepth(Node root) {
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> counts = new LinkedList<>();
        q.add(root);
        counts.add(1);
        while (!q.isEmpty()) {
            Node node = q.poll();
            int count = counts.remove();
            if (node.left != null) {
                q.add(node.left);
                counts.add(count + 1);
            }
            if (node.right != null) {
                q.add(node.right);
                counts.add(count + 1);
            }
            if (node.left == null && node.right == null) {
                return count;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Tree Min Depth : " + minDepth(root));
    }
}
