package trees;

public class LCAOfBinaryTree {

    private static class NodeWrapper {
        Node node;
    }

    private static boolean findLCA(Node root, NodeWrapper lca, Node x, Node y) {
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

    public static Node findLCA(Node root, Node x, Node y) {
        NodeWrapper lca = new NodeWrapper();
        findLCA(root, lca, x, y);
        return lca.node;
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
        Node lca = findLCA(root, root.left, root.right);
        System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
//        root.left.right        = new Node(4);
//        root.right.left        = new Node(5);
//        root.right.right       = new Node(6);
//        root.right.left.left   = new Node(7);
//        root.right.right.right = new Node(8);
//        Node lca;
//        lca = findLCA(root, root.left, root.right);
//        System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
//        lca = findLCA(root, root.right.left.left, new Node(10));
//        System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
//        lca = findLCA(root, root.right.left.left, root.right.left);
//        System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
//        lca = findLCA(root, root.right.left.left, root.right.left.left);
//        System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
//        lca = findLCA(root, root.right.left.left, root.right.left.left);
//        System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
//        findLCA(root, root.right.left.left, root.right.left);
//        System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
//        lca = findLCA(root, root.left, root.right.left);
//        System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
    }
}
