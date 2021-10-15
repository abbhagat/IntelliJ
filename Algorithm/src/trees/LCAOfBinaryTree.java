package trees;

import static trees.SearchBT.searchBT;

public class LCAOfBinaryTree {

    static class NodeWrapper {
        public Node node;
    }

    public static boolean findLCA(Node root, NodeWrapper lca, Node x, Node y) {
        if (root == null) {
            return false;
        }
        if (root == x || root == y) {
            lca.node = root;
            return true;
        }
        boolean left  = findLCA(root.left,  lca, x, y);
        boolean right = findLCA(root.right, lca, x, y);
        if (left && right) {
            lca.node = root;
        }
        return left || right;
    }

    public static void findLCA(Node root, Node x, Node y) {
        NodeWrapper lca = new NodeWrapper();
        if (searchBT(root, x) && searchBT(root, y)) {
            findLCA(root, lca, x, y);
        }
        System.out.println(lca.node != null ? "LCA is " + lca.node.num : "LCA does not exist");
    }

    public static void main(String[] args) {

        /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
        */

        Node root              = new Node(1);
        root.left              = new Node(2);
        root.right             = new Node(3);
        root.left.right        = new Node(4);
        root.right.left        = new Node(5);
        root.right.right       = new Node(6);
        root.right.left.left   = new Node(7);
        root.right.right.right = new Node(8);

        findLCA(root, root.right.left.left, root.right.right);
        findLCA(root, root.right.left.left, new Node(10));
        findLCA(root, root.right.left.left, root.right.left.left);
        findLCA(root, root.right.left.left, root.right.left);
        findLCA(root, root.left, root.right.left);
    }
}
