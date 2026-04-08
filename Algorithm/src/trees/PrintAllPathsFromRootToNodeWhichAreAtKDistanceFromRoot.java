package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static trees.CreateBST.createBST;

public class PrintAllPathsFromRootToNodeWhichAreAtKDistanceFromRoot {

  private static List<List<Integer>> findPath(Node root, int k, LinkedList<Integer> list, List<List<Integer>> lists) {
    if (root == null) {
      return Collections.emptyList();
    }
    list.add(root.num);
    if (k == 0) {
      List<Integer> path = new ArrayList<>(list);
      lists.add(path);
      list.removeLast();
      return lists;
    }
    findPath(root.left,  k - 1, list, lists);
    findPath(root.right, k - 1, list, lists);
    list.removeLast();
    return lists;
  }

  private static void findPath(Node root, int k, LinkedList<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.num);
    if (k == 0) {
      System.out.println(list);
      list.removeLast();
      return;
    }
    findPath(root.left,  k - 1, list);
    findPath(root.right, k - 1, list);
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
    List<List<Integer>> lists = findPath(root, 4, new LinkedList<>(), new ArrayList<>());
    System.out.println(lists);

    findPath(root, 4, new LinkedList<>());
  }
}
