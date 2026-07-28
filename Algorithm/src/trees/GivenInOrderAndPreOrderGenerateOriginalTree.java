package trees;

import static trees.TreeTraversal.preorder;

public class GivenInOrderAndPreOrderGenerateOriginalTree {

  public static class PreIndex {
    int index;
  }

  public static Node buildTree(int[] inorder, int[] preorder, int start, int end, PreIndex preIndex) {
    if (start > end) {
      return null;
    }
    Node root = new Node(preorder[preIndex.index++]);
    if (start == end) {
      return root;
    }
    int mid    = search(inorder, root.num, start, end);
    root.left  = buildTree(inorder, preorder, start, mid - 1, preIndex);
    root.right = buildTree(inorder, preorder, mid + 1, end, preIndex);
    return root;
  }

  private static int search(int[] inorder, int num, int start, int end) {
    for (int i = start; i <= end; i++) {
      if (inorder[i] == num) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] inorder = {10, 8, 6, 4, 2, 1, 3, 5, 7, 9};
    int[] preorder = {1, 2, 4, 6, 8, 10, 3, 5, 7, 9};
    PreIndex preIndex = new PreIndex();
    preIndex.index = 0;
    Node root = buildTree(inorder, preorder, 0, inorder.length - 1, preIndex);
    preorder(root);
  }
}
