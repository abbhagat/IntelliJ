package trees;

import static trees.TreeTraversal.inorder;

public class IsTreeIdentical {

    private static boolean isIdentical(Node root1, Node root2) {
        if (root1 == root2 & root1 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.num == root2.num) {
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        }
        return false;
    }

    public static void main(String[] args) {
        Node root1       = new Node(1);
        root1.left       = new Node(2);
        root1.right      = new Node(3);
        root1.left.left  = new Node(4);
        root1.left.right = new Node(5);
        inorder(root1);
        System.out.println();
        Node root2       = new Node(1);
        root2.left       = new Node(2);
        root2.right      = new Node(3);
        root2.left.left  = new Node(4);
        root2.left.right = new Node(5);
        inorder(root2);
        System.out.println();
        System.out.println(isIdentical(root1, root2) ? "Identical" : "Not Identical");
    }
}