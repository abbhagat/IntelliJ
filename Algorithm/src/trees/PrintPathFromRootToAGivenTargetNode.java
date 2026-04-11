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
    Node root = createBST();
    if (!printPath(root, 10)) {
      System.out.println("No Path");
    }
    System.out.println();
    printPath(root, 11, new LinkedList<>());
  }
}
