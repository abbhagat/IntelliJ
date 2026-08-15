package trees;

import java.util.LinkedList;
import java.util.Queue;

import static trees.BinaryTree.createBST;

// Time Complexity: O(n)
// Auxiliary Space: O(n)

public class LevelOrderTraversal {

  private static void printLevelOrder(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      while (size != 0) {
        root = q.poll();
        System.out.print(root.num + " ");
        if (root.left != null) {
          q.add(root.left);
        }
        if (root.right != null) {
          q.add(root.right);
        }
        size--;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    printLevelOrder(createBST());
  }
}
