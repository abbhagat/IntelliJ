package trees;

import static trees.BinaryTree.createBST;

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
    Node root  = createBST();
    Node lca = findLCA(root, root.left, root.right.right.right);
    System.out.println(lca != null ? "LCA is " + lca.num : "LCA does not exist");
  }
}
