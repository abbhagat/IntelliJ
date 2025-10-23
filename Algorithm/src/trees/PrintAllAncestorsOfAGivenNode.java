package trees;

// Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.

/*
                     1
                  /     \
                2        3
               / \
              4  5
             / \
            7   8
               /
              10
 */

import java.util.LinkedList;

public class PrintAllAncestorsOfAGivenNode {

  private static boolean printAllAncestor(Node root, int num) {
    if (root == null) {
      return false;
    }
    if (root.num == num) {
      return true;
    }
    boolean left = printAllAncestor(root.left, num);
    boolean right = printAllAncestor(root.right, num);
    if (left || right) {
      System.out.print(root.num + " ");
      return true;
    }
    return false;
  }

  private static void printAllAncestor(Node root, int num, LinkedList<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.num);
    if (root.num == num) {
      list.removeLast();
      System.out.println(list);
      return;
    }
    printAllAncestor(root.left, num, list);
    printAllAncestor(root.right, num, list);
    list.removeLast();
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(7);
    root.left.left.right = new Node(8);
    root.left.left.right.left = new Node(10);
    printAllAncestor(root, 10);
    System.out.println();
    printAllAncestor(root, 10, new LinkedList<>());
  }
}
