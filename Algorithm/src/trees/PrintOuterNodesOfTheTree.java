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
      Node first = null, last = null;
      for (int i = 1; i <= size; i++) {
        Node node = q.poll();
        if (i == 1) {
          first = node;
        }
        if (i == size) {
          last = node;
        }
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null){
          q.add(node.right);
        }
      }
      if (size == 1) {
        System.out.println(first.num);
      } else {
        System.out.println(flag ? first.num + " " + last.num : last.num + " " + first.num);
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
