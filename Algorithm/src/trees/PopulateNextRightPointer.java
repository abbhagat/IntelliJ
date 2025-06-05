package trees;

import static trees.TreeTraversal.inorder;

public class PopulateNextRightPointer {

    private static void connect(Node root) {
        while (root != null && root.left != null) {
            Node node = root;
            while (node != null) {
                if (node.left != null) {
                    node.left.right = node.right;
                }
                if (node.right != null) {
                    node.right.right = node.right.left;
                }
                node = node.right;
            }
            root = root.left;
        }
    }

    public static void main(String[] args) {
        /*
                          1
                         / \
                        2   3
                       / \
                      4   5
                     /
                    6
       */
        Node root           = new Node(1);
        root.left           = new Node(2);
        root.right          = new Node(3);
        root.left.left      = new Node(4);
        root.left.right     = new Node(5);
        root.left.left.left = new Node(6);
        inorder(root);
        connect(root);
        System.out.println();
        inorder(root);
    }
}
