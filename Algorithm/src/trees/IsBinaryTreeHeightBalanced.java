package trees;


import static java.lang.Integer.max;
import static java.lang.Math.abs;

/**
 * To check if a tree is height-balanced, get the height of left and right subtrees.
 * Return true if difference between heights is not more than 1 and left and right subtrees are balanced, otherwise return false.
 * A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree.
 */
public class IsBinaryTreeHeightBalanced {

  private static boolean isBinaryTreeHeightBalanced(Node root) {
    return treeHeight(root) != -1;
  }

  private static int treeHeight(Node root) {
    if (root == null) {
      return 0;
    }
    int lH = treeHeight(root.left);
    int rH = treeHeight(root.right);
    if (lH == -1 || rH == -1 || abs(lH - rH) > 1) {
      return -1;
    }
    return max(lH, rH) + 1;
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(12);
    root.right = new Node(15);
    root.left.left = new Node(25);
    root.left.right = new Node(30);
    root.right.left = new Node(36);
    System.out.println(isBinaryTreeHeightBalanced(root) ? "Balanced" : "Not Balanced");
  }
}
