package trees;

import java.util.LinkedList;
import java.util.Queue;

public class IsOddEvenTree {

    private static boolean isEvenOddTree(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 0, prev = -1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                level++;
                prev = -1;
            }
            if (node != null) {
                if (level % 2 == 0) {
                    if (node.num % 2 == 0 || (prev != -1 && prev >= node.num)) {
                        return false;
                    }
                    prev = node.num;
                }
                if (level % 2 != 0) {
                    if (node.num % 2 != 0 || (prev != -1 && prev <= node.num)) {
                        return false;
                    }
                    prev = node.num;
                }
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
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(10);
        root.right = new Node(4);
        root.left.left = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.left.left = new Node(12);
        root.left.left.right = new Node(8);
        root.right.left.left = new Node(6);
        root.right.right.right = new Node(2);
        System.out.println(isEvenOddTree(root));
    }
}
