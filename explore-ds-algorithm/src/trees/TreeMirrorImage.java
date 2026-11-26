package trees;

import java.util.LinkedList;
import java.util.Queue;
import static trees.BinaryTree.createBST;
import static trees.TreeTraversal.inorder;

// Time Complexity : O(n)
public class TreeMirrorImage {

  public static Node mirrorImage(Node root) {
    if (root == null) {
      return null;
    }
    Node left  = mirrorImage(root.left);
    Node right = mirrorImage(root.right);
    root.left  = right;
    root.right = left;
    return root;
  }

  public static void mirrorImageUsingIteration(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      Node node = q.poll();
      swap(node);
      if (node.left != null) {
        q.add(node.left);
      }
      if (node.right != null) {
        q.add(node.right);
      }
    }
  }

  private static void swap(Node node) {
    Node temp = node.left;
    node.left = node.right;
    node.right = temp;
  }

  public static void main(String[] args) {
    Node root = createBST();
    inorder(root);
    root = mirrorImage(root);
    System.out.println();
    inorder(root);
    mirrorImageUsingIteration(root);
    System.out.println();
    inorder(root);
  }
}
