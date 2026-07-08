package trees;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(N)
// Space Complexity: O(W) Where W is the maximum width of the binary tree (maximum number of nodes at any level).
public class PrintOuterNodesOfTheTree {

  private static void printOuterNodes(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    boolean flag = true;
    while (!q.isEmpty()) {
      int size = q.size();
      int first = 0, last = 0;
      for (int i = 1; i <= size; i++) {
        Node node = q.poll();
        if (node != null) {
          if (i == 1) {
            first = node.num;
          }
          if (i == size) {
            last = node.num;
          }
          if (node.left != null) {
            q.add(node.left);
          }
          if (node.right != null) {
            q.add(node.right);
          }
        }
      }
      if (size == 1) {
        System.out.println(first);
      } else if (flag) {
        System.out.println(first + " " + last);
      } else {
        System.out.println(last + " " + first);
      }
      flag = !flag;
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
    printOuterNodes(root);
  }
}
