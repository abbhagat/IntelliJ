package trees;

import static java.lang.Integer.min;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
// Time  Complexity: O(N) (visit each node once)
// Space Complexity: O(H) (recursion stack, H = height)
public class BinaryTreeMinimumHeight {

  private static int treeMinHeight(Node root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    if (root.left == null) {
      return 1 + treeMinHeight(root.right);
    }
    if (root.right == null) {
      return 1 + treeMinHeight(root.left);
    }
    return 1 + min(treeMinHeight(root.left), treeMinHeight(root.right));
  }

  public static void main(String[] args) {
      /*
                 1
               /   \
             2      3
           /
          4
       */
    Node root      = new Node(1);
    root.left      = new Node(2);
    root.right     = new Node(3);
    root.left.left = new Node(4);
    System.out.println("Tree Min Depth : " + treeMinHeight(root));
  }
}
