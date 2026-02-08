package trees;

import static java.lang.Integer.min;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

public class BinaryTreeMinimumHeight {

  private static int treeMinHeight(Node root) {
    if (root == null) {
      return 0;
    }
    int lH = treeMinHeight(root.left);
    int rH = treeMinHeight(root.right);
    return min(lH, rH) + 1;
  }

  public static void main(String[] args) {
      /*
                 1
               /   \
             2      3
           /
          4
       */
    Node root                    = new Node(1);
    root.left                    = new Node(2);
    root.right                   = new Node(3);
    root.left.left               = new Node(4);
    System.out.println("Tree Min Depth : " + treeMinHeight(root));
  }
}
