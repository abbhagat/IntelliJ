package trees;

import java.util.LinkedList;
import java.util.Queue;
import static java.lang.Integer.min;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

public class BinaryTreeMinimumHeight {

  private static int treeMinHeight(Node root) {
    if (root == null) {
      return -1;
    }
    int lH = treeMinHeight(root.left);
    int rH = treeMinHeight(root.right);
    return min(lH, rH) + 1;
  }

  public static int minDepth(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    int height = 0;
    while (!q.isEmpty()) {
      Node node = q.poll();
      if (node == null) {
        height++;
      }
      if (node != null) {
        if (node.left == null && node.right == null) {
          return height;
        }
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      } else if (!q.isEmpty()) {
        q.add(null);
      }
    }
    return 0;
  }

  public static void main(String[] args) {
            /*
                    1
                  /   \
                2      3
              /  \    /  \
             4    5  6    7
                         / \
                        8   9
                             \
                              10
       */
    Node root                    = new Node(1);
    root.left                    = new Node(2);
    root.right                   = new Node(3);
    root.left.left               = new Node(4);
    root.left.right              = new Node(5);
    root.right.left              = new Node(6);
    root.right.right             = new Node(7);
    root.right.right.left        = new Node(8);
    root.right.right.right       = new Node(9);
    root.right.right.right.right = new Node(10);
    System.out.println("Tree Min Depth : " + minDepth(root));
    System.out.println("Tree Min Depth : " + treeMinHeight(root));
  }
}
