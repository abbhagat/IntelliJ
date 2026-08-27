package trees;

// Time  Complexity : O(n)
// Space Complexity : O(H)
public class LCAOfBinaryTree {

  public static Node findLCA(Node root, Node x, Node y) {
    if (root == null || root == x || root == y) {
      return root;
    }
    Node left  = findLCA(root.left,  x, y);
    Node right = findLCA(root.right, x, y);
    if (left != null && right != null) {
      return root;
    }
    return left != null ? left : right;
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

    Node root  = new Node(1);
    root.left  = new Node(2);
    root.right = new Node(3);
    Node lca = findLCA(root, root.left, root.right);
    System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
    root.left.right        = new Node(4);
    root.right.left        = new Node(5);
    root.right.right       = new Node(6);
    root.right.left.left   = new Node(7);
    root.right.right.right = new Node(8);
    lca = findLCA(root, root.left, root.right);
    System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
    lca = findLCA(root, root.right.left.left, new Node(10));
    System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
    lca = findLCA(root, root.right.left.left, root.right.left);
    System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
    lca = findLCA(root, root.right.left.left, root.right.left.left);
    System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
    lca = findLCA(root, root.right.left.left, root.right.left.left);
    System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
    findLCA(root, root.right.left.left, root.right.left);
    System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
    lca = findLCA(root, root.left, root.right.left);
    System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
  }
}
