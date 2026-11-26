package trees;

import static java.lang.Integer.max;
import static trees.BinaryTree.createBST;

public class MaxDistanceBetweenAnyNodes {

  private static int max = Integer.MIN_VALUE;

  private static int treeHeight(Node root) {
    if (root == null) {
      return 0;
    }
    int lH = treeHeight(root.left);
    int rH = treeHeight(root.right);
    max    = max(max, lH + rH);
    return max(lH, rH) + 1;
  }

  public static void main(String[] args) {
    Node root = createBST();
    treeHeight(root);
    System.out.println(max);
  }
}
