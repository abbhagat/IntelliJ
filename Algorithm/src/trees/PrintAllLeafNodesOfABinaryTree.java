package trees;

import static trees.CreateBST.createBST;

public class PrintAllLeafNodesOfABinaryTree {

  private static void printLeafNodes(Node root) {
    if (root != null) {
      if (root.left == null && root.right == null) {
        System.out.println(root.num);
      }
      printLeafNodes(root.left);
      printLeafNodes(root.right);
    }
  }

  public static void main(String[] args) {
    int[] a = {50, 25, 100, 10, 30, 90, 120};
    Node root = null;
    for (int x : a) {
      root = createBST(root, x);
    }
    printLeafNodes(root);
  }
}
