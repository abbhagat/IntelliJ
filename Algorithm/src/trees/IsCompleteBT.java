package trees;

import static trees.CreateBST.createBST;

// Time Complexity O(n)
public class IsCompleteBT {

  private static boolean isCompleteBT(Node root) {
    if (root == null) {
      return true;
    }
    if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
      return false;
    }
    return isCompleteBT(root.left) && isCompleteBT(root.right);
  }

  public static void main(String... args) {
    int[] a = {30, 10, 50, 5, 20, 40, 60};
    Node root = null;
    for (int x : a) {
      root = createBST(root, x);
    }
    System.out.println("Complete Binary Tree :" + isCompleteBT(root));
  }
}
