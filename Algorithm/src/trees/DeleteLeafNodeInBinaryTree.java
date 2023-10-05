package trees;

import static trees.TreeTraversal.inorder;

// Time Complexity: O(n)
public class DeleteLeafNodeInBinaryTree {

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
         /*
                                1
                            /      \
                           2        3
                         /   \       \
                        4     5       6
                             / \      \
                            7  8       9
                                        \
                                        10
         */
        Node root              = new Node(1);
        root.left              = new Node(2);
        root.right             = new Node(3);
        root.left.left         = new Node(4);
        root.left.right        = new Node(5);
        root.right.right       = new Node(6);
        root.left.right.left   = new Node(7);
        root.left.right.right  = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);
        inorder(root);
        System.out.println();
        root = deleteLastNode(root);
        inorder(root);
    }
}
