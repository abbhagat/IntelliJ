package trees;

import java.util.LinkedList;
import static trees.BinaryTree.createBST;

// Time complexity: O(n)
public class PrintPathFromRootToAGivenTargetNode {

  private static boolean printPath(Node root, int num) {
    if (root == null) {
      return false;
    }
    if (root.num == num) {
      System.out.print(root.num + " ");
      return true;
    }
    boolean left  = printPath(root.left, num);
    boolean right = printPath(root.right, num);
    if (left || right) {
      System.out.print(root.num + " ");
      return true;
    }
    return false;
  }

  private static void printPath(Node root, int target, LinkedList<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.num);
    if (root.num == target) {
      System.out.println(list);
      list.removeLast();
      return;
    }
    printPath(root.left, target, list);
    printPath(root.right, target, list);
    list.removeLast();
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
    if (!printPath(root, 8)) {
      System.out.println("No Path");
    }
    System.out.println();
    printPath(root, 8, new LinkedList<>());
  }
}
