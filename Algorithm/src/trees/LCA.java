package trees;

import static trees.CreateBST.createBST;

// Time Complexity: O(h) h = Height of the BST
// Auxiliary Space: O(h) h = Height of the BST
public class LCA {

  public static Node lca(Node root, int x, int y) {
    if (root == null) {
      return null;
    }
    if ((x < root.num && y > root.num) || (x > root.num && y < root.num)) {
      return root;
    }
    if (x < root.num && y < root.num) {
      return lca(root.left, x, y);
    }
    if (x > root.num && y > root.num) {
      return lca(root.right, x, y);
    }
    return root;
  }

  public static void main(String[] args) {
    int[] a = {30, 10, 50, 5, 20, 40, 60, 1, 6};
    Node root = null;
    for (int x : a) {
      root = createBST(root, x);
    }
    Node lca = lca(root, 1, 20);
    System.out.println(lca.num);
  }
}
