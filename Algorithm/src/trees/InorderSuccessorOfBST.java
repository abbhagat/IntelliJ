package trees;

// Given a BST and a node. Find the inorder successor of that node in the BST
// Time Complexity O(n)
public class InorderSuccessorOfBST {

    private static Node inorderSuccessor(Node root, Node target) {
        if (root == null) {
            return null;
        }
        if (target.num < root.num) {
            Node node = inorderSuccessor(root.left, target);
            return node == null ? root : node;
        } else {
            return inorderSuccessor(root.right, target);
        }
    }

    public static void main(String[] args) {
        Node root       = new Node(2);
        root.left       = new Node(1);
        root.right      = new Node(3);
        Node node = inorderSuccessor(root, root.left);
        System.out.println(node == null ? null : node.num);
        root                = new Node(5);
        root.left           = new Node(3);
        root.right          = new Node(6);
        root.left.left      = new Node(2);
        root.left.right     = new Node(4);
        root.left.left.left = new Node(1);
        node = inorderSuccessor(root, root.right);
        System.out.println(node == null ? null : node.num);
    }
}
