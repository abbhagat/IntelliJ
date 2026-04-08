package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintOuterNodesOfTheTree {

  private static void printOuterNodes(Node root) {
    if (root == null) {
      return;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    boolean flag = true;
    while (!q.isEmpty()) {
      int size = q.size();
      Node first = null, last = null;
      for (int i = 0; i < size; i++) {
        Node node = q.poll();
        if (i == 0) {
          first = node;
        }
        if (i == size - 1) {
          last = node;
        }
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null){
          q.add(node.right);
        }
      }
      if (first == last) {
        System.out.println(first.num);
      } else {
        System.out.println(flag  ? first.num + " " + last.num : last.num + " " + first.num);
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
