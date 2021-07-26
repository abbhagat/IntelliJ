package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Tree Array = {1,2,3,4,5}
Inorder traversal of the constructed tree is
4 2 5 1 3
Inorder traversal of the mirror tree is
3 1 5 2 4
 */
public class TreeMirrorImage {

    public static Node mirrorImage(Node root) {
        if (root == null) {
            return root;
        }
        Node left = mirrorImage(root.left);
        Node right = mirrorImage(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static Node mirrorImageUsingIteration(Node root) {
        if (null != root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (q.size() > 0) {
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
}
