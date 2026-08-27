package trees;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Why use Integer.MAX_VALUE?
 * Consider this tree:
 *     1
 *    /
 *   2
 *  /
 * 3
 * If you simply wrote: return Math.min(treeMinHeight(root.left), treeMinHeight(root.right)) + 1;
 * then: treeMinHeight(2) = min(0, ?) + 1
 * Since the right child is null, it would incorrectly contribute 0. The result would become 1, which is wrong.
 * A null child does not represent a path to a leaf, so you assign it Integer.MAX_VALUE, so it is never chosen
 */
// Time  Complexity: O(N) (visit each node once)
// Space Complexity: O(H) (recursion stack, H = height)
public class BinaryTreeMinimumHeight {

  private static int treeMinHeight(Node root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 0;
    }
    int lH = (root.left  == null) ? MAX_VALUE : treeMinHeight(root.left);  // A null child is not a valid path to a leaf,
    int rH = (root.right == null) ? MAX_VALUE : treeMinHeight(root.right); // so we must make sure it is never selected by min().
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
    Node root      = new Node(1);
    root.left      = new Node(2);
    root.right     = new Node(3);
    root.left.left = new Node(4);
    System.out.println("Tree Min Depth : " + treeMinHeight(root));
  }
}
