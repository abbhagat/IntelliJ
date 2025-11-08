package trees;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity  : O(n)
// Space Complexity : O(2^h)
public class IterativeTreeTraversal {

    public static void iterativeTreeTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root == null) {
                System.out.println();
            }
            if (root != null) {
                System.out.print(root.num + " ");
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            } else if (!q.isEmpty()) {
                q.add(null);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        iterativeTreeTraversal(root);
    }
}
