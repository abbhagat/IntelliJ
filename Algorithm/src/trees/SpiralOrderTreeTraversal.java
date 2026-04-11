package trees;

import java.util.Deque;
import java.util.LinkedList;
import static trees.BinaryTree.createBST;

public class SpiralOrderTreeTraversal {

  private static void spiralOrderTreeTraversal(Node root) {
    Deque<Node> q = new LinkedList<>();
    q.addFirst(root);
    boolean flag = true;
    while (!q.isEmpty()) {
      int size = q.size();
      if (flag) {
        while (size != 0) {
          Node node = q.pollFirst();
          if (node != null) {
            System.out.print(node.num + " ");
            if (node.left != null) {
              q.addLast(node.left);
            }
            if (root.right != null) {
              q.addLast(node.right);
            }
          }
          size--;
        }
      } else {
        while (size != 0) {
          Node node = q.pollLast();
          if (node != null) {
            System.out.print(node.num + " ");
            if (node.right != null) {
              q.addFirst(node.right);
            }
            if (node.left != null) {
              q.addFirst(node.left);
            }
          }
          size--;
        }
      }
      System.out.println();
      flag = !flag;
    }
  }

  public static void main(String[] args) {
             /*
                  4
                /  \
               2    6
              / \  / \
             1  3 5   7
         */
    Node root = createBST();
    spiralOrderTreeTraversal(root);
  }
}
