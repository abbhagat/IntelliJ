package trees;

import java.util.LinkedList;
import java.util.Queue;

import static trees.TreeTraversal.inorder;

/*
Tree Array = {1,2,3,4,5}
Inorder traversal of the constructed tree is
4 2 5 1 3
Inorder traversal of the mirror tree is
7 3 6 1 5 2 4
 */
public class TreeMirrorImage {

    public static Node mirrorImage(Node root) {
        if (root != null) {
            Node left = mirrorImage(root.left);
            Node right = mirrorImage(root.right);
            root.left = right;
            root.right = left;
        }
        return root;
    }

    public static Node mirrorImageUsingIteration(Node root) {
        if (null != root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node node = q.poll();
                Node temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root           = new Node(1);
        root.left           = new Node(2);
        root.right          = new Node(3);
        root.left.left      = new Node(4);
        root.left.right     = new Node(5);
        root.right.left     = new Node(6);
        root.right.right    = new Node(7);
        inorder(root);
        root = mirrorImage(root);
        System.out.println();
        inorder(root);
        root = mirrorImageUsingIteration(root);
        System.out.println();
        inorder(root);
    }
}
