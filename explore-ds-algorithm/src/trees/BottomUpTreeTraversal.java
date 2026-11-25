package trees;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.max;
import static trees.BinaryTree.createBST;

/**
 *                   1
 *                  / \
 *                2    3
 *               / \  / \
 *              4   5 6  7
 * O/P :- [[4, 5, 6, 7], [2, 3], [1]]
 * The key idea is that the height of a node is used as the index in the list.
 * list.get(0) → all leaf nodes (height = 0)
 * list.get(1) → all nodes whose height is 1
 * list.get(2) → all nodes whose height is 2
 * and so on...
 */

public class BottomUpTreeTraversal {

  public static List<List<Integer>> bottomUpTraversal(Node root) {
    List<List<Integer>> list = new ArrayList<>();
    treeHeight(root, list);
    return list;
  }

  private static int treeHeight(Node root, List<List<Integer>> list) {
    if (root == null) {
      return -1;
    }
    int lH = treeHeight(root.left,  list);
    int rH = treeHeight(root.right, list);
    int height = max(lH, rH) + 1;
    if (list.size() <= height) {
      list.add(new ArrayList<>());
    }
    list.get(height).add(root.num);
    return height;
  }

  public static void main(String[] args) {
    Node root         = new Node(1);
    root.left         = new Node(2);
    root.right        = new Node(3);
    root.left.left    = new Node(4);
    root.left.right   = new Node(5);
    root.right.left   = new Node(6);
    root.right.right  = new Node(7);
    System.out.println(bottomUpTraversal(root));
  }
}
