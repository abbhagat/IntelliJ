package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static trees.CreateBST.createBST;

public class PrintAllPathFromRootToLeafNodes {

  private static void findPath(Node root, LinkedList<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.num);
    if (root.left == null && root.right == null) {
      System.out.println(list);
      list.removeLast();
      return;
    }
    findPath(root.left, list);
    findPath(root.right, list);
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
    findPath(root, new LinkedList<>());
  }
}
