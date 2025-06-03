package trees;

/**
Given a BST and a node. Find the inorder successor of that node in the BST
In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree.
Inorder Successor is NULL for the last node in Inorder traversal.
*/

// Time Complexity O(log n)
public class InorderSuccessorOfBST {

    private static Node inorderSuccessor(Node root, Node target) {
        if (root == null) {
            return null;
        }
        if (target.num < root.num) {
            Node   node = inorderSuccessor(root.left, target);
            return node == null ? root : node;
        }
        return inorderSuccessor(root.right, target);
    }

    public static void main(String[] args) {
        Node root      = new Node(2);
        root.left      = new Node(1);
        root.right     = new Node(3);
        Node node = inorderSuccessor(root, root.left);
        System.out.println(node == null ? null : node.num);
        node = inorderSuccessor(root, root);
        System.out.println(node == null ? null : node.num);
        root                  = new Node(20);
        root.left             = new Node(8);
        root.right            = new Node(22);
        root.left.left        = new Node(4);
        root.left.right       = new Node(12);
        root.left.right.left  = new Node(10);
        root.left.right.right = new Node(14);
        node = inorderSuccessor(root, root.left.right.right);
        System.out.println(node == null ? null : node.num);
    }
}
