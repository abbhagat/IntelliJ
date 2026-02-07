package trees;

import java.util.LinkedList;
import java.util.Queue;

import static trees.TreeTraversal.inorder;

/**
 * Tree Array = {1,2,3,4,5}
 * Inorder traversal of the tree is 4 2 5 1 3
 * Inorder traversal of the tree is 7 3 6 1 5 2 4
 */
// Time Complexity : O(n)
public class TreeMirrorImage {

  public static Node mirrorImage(Node root) {
    if (root == null) {
      return null;
    }
    Node right = mirrorImage(root.right);
    Node left  = mirrorImage(root.left);
    root.left  = right;
    root.right = left;
    return root;
  }

  public static void mirrorImageUsingIteration(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      Node node = q.poll();
      Node temp = node.left;
      node.left = node.right;
      node.right = temp;
      if (node.left != null) {
        q.add(node.left);
      }
      if (node.right != null) {
        q.add(node.right);
      }
    }
  }

  public static void main(String[] args) {
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(7);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(8);
    inorder(root);
    root = mirrorImage(root);
    System.out.println();
    inorder(root);
    mirrorImageUsingIteration(root);
    System.out.println();
    inorder(root);
  }
}
