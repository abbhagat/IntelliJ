package trees;

import static java.lang.Math.max;
import static trees.BinaryTree.createBST;

// Time  Complexity: O(n)
// Space Complexity: O(2^h) - 1
public class TreeHeight {

  public static int treeHeight(Node root) {
    return null == root ? 0 : max(treeHeight(root.left), treeHeight(root.right)) + 1;
  }

  public static int height(Node root) {
    if (root == null) {
      return 0;
    }
    int lH = height(root.left);
    int rH = height(root.right);
    return max(lH, rH) + 1;
  }

  public static void main(String[] args) {
    Node root = createBST();
    System.out.println("Tree Height " + treeHeight(root));
    System.out.println("Tree Height " + height(root));
  }
}
