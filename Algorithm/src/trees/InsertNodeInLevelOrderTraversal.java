package trees;

import java.util.LinkedList;
import java.util.Queue;

import static trees.TreeTraversal.inorder;

public class InsertNodeInLevelOrderTraversal {

  private static void insertNode(Node root, int n) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      root = q.poll();
      if (root.left != null) {
        q.add(root.left);
      } else {
        root.left = new Node(n);
        break;
      }
      if (root.right != null) {
        q.add(root.right);
      } else {
        root.right = new Node(n);
        break;
      }
    }
  }

  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(3);
    root.left.left = new Node(2);
    root.right = new Node(7);
    root.right.left = new Node(6);
    root.right.right = new Node(9);
    inorder(root);
    insertNode(root, 4);
    insertNode(root, 8);
    System.out.println();
    inorder(root);
  }
}
