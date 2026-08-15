package trees;

import static trees.BinaryTree.createBST;
import static trees.TreeTraversal.inorder;

// Time Complexity: O(n)
public class DeleteLeafNodeInBinaryTree {

  private static Node deleteLeafNode(Node root) {
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      return null;
    }
    root.left  = deleteLeafNode(root.left);
    root.right = deleteLeafNode(root.right);
    return root;
  }

  public static void main(String[] args) {
    Node root = createBST();
    inorder(root);
    System.out.println();
    root = deleteLeafNode(root);
    inorder(root);
  }
}
