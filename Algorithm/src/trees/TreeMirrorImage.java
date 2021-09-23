package trees;

import java.util.Stack;

import static trees.TreeTraversal.inorder;

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
            Stack<Node> s = new Stack<>();
            s.add(root);
            while (!s.isEmpty()) {
                Node node = s.pop();
                Node temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    s.add(node.left);
                }
                if (node.right != null) {
                    s.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inorder(root);
        root = mirrorImageUsingIteration(root);
        System.out.println();
        inorder(root);
    }
}
