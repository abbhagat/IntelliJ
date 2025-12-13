package trees;

import static trees.TreeTraversal.inorder;

// Time Complexity: O(n)
public class ConvertSortedArrayToBalancedTree {

  private static Node sortedArrayToBST(int[] a, int low, int high) {
    if (low > high) {
      return null;
    }
    int mid = (low + high) / 2;
    Node root  = new Node(a[mid]);
    root.left  = sortedArrayToBST(a, low, mid - 1);
    root.right = sortedArrayToBST(a, mid + 1, high);
    return root;
  }

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
    Node root = sortedArrayToBST(a, 0, a.length - 1);
    inorder(root);
  }
}
