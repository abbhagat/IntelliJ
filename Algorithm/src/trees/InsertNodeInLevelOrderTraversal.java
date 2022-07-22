package trees;

import java.util.LinkedList;
import java.util.Queue;

import static trees.TreeTraversal.inorder;

public class InsertNodeInLevelOrderTraversal {

    private static void insertNode(Node root, int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (true) {
            root = q.poll();
            if (root.left == null) {
                root.left = new Node(n);
                return;
            } else {
                q.add(root.left);
            }
            if (root.right == null) {
                root.right = new Node(n);
                return;
            } else {
                q.add(root.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root        = new Node(10);
        root.left        = new Node(11);
        root.left.left   = new Node(7);
        root.right       = new Node(9);
        root.right.left  = new Node(15);
        root.right.right = new Node(8);
        inorder(root);
        insertNode(root, 12);
        System.out.println();
        inorder(root);
    }
}
