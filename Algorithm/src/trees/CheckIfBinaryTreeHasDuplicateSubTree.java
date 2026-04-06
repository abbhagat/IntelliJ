package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * A duplicate subtree means two or more subtrees with the same structure and same node values exist in a binary tree.
          1
         / \
        2   3
       /   / \
      4   2   4
         /
        4

 Duplicate subtrees

          2  4 (leaf ignored usually)
         /
        4
*/

// Time Complexity : O(n)
// Space Complexity: O(n)
public class CheckIfBinaryTreeHasDuplicateSubTree {

  private static final Map<String, Integer> map = new HashMap<>();
  private static boolean found = false;

  public static boolean hasDuplicateSubtree(Node root) {
    serialize(root);
    return found;
  }

  private static String serialize(Node root) {
    if (root == null) {
      return "null";
    }
    String left    = serialize(root.left);
    String right   = serialize(root.right);
    String subtree = root.num + "," + left + "," + right;
    if (!left.equals("null") || !right.equals("null")) {       // Ignore leaf nodes
      int count = map.getOrDefault(subtree, 0);
      if (count == 1) {
        found = true;
      }
      map.put(subtree, count + 1);
    }
    return subtree;
  }

  public static void main(String[] args) {
    Node root            = new Node(1);
    root.left            = new Node(2);
    root.right           = new Node(3);
    root.left.left       = new Node(4);
    root.right.left      = new Node(2);
    root.right.right     = new Node(4);
    root.right.left.left = new Node(4);
    System.out.println(hasDuplicateSubtree(root));
  }
}
