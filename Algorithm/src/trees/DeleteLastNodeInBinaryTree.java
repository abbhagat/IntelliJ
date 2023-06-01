package trees;

import static trees.TreeTraversal.inorder;

// Time Complexity: O(n)
public class DeleteLastNodeInBinaryTree {

    private static Node deleteLastNode(Node root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return null;
            }
            root.left  = deleteLastNode(root.left);
            root.right = deleteLastNode(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root  = new Node(2);
        root.left  = new Node(1);
        root.right = new Node(3);
        inorder(root);
        System.out.println();
        root = deleteLastNode(root);
        inorder(root);
    }
}
