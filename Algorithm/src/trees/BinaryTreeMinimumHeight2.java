package trees;

import java.util.LinkedList;
import static java.lang.Integer.min;

public class BinaryTreeMinimumHeight2 {

  private static int minSize = Integer.MAX_VALUE;

  private static void treeMinHeight(Node root, LinkedList<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.num);
    if (root.left == null && root.right == null) {
      minSize = min(minSize, list.size());
    }
    treeMinHeight(root.left,  list);
    treeMinHeight(root.right, list);
    list.removeLast();
  }

  public static void main(String[] args) {
      /*
                 1
               /   \
             2      3
           /
          4
       */
    Node root      = new Node(1);
    root.left      = new Node(2);
    root.right     = new Node(3);
    root.left.left = new Node(4);
    treeMinHeight(root, new LinkedList<>());
    System.out.println("Tree Min Depth : " + minSize);
  }
}
