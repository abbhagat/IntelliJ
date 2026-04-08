package trees;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity  : O(n)
// Space Complexity : O(2^h)
public class IterativeTreeTraversal {

  public static void iterativeTreeTraversal(Node root) {
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
      /*
                 1
               /  \
              2    3
            /   \   \
           4     5   6
                / \   \
               7  8    9
                        \
                        10
     */
    Node root                    = new Node(1);
    root.left                    = new Node(2);
    root.right                   = new Node(3);
    root.left.left               = new Node(4);
    root.left.right              = new Node(5);
    root.right.right             = new Node(6);
    root.left.right.left         = new Node(7);
    root.left.right.right        = new Node(8);
    root.right.right.right       = new Node(9);
    root.right.right.right.right = new Node(10);
    iterativeTreeTraversal(root);
  }
}
