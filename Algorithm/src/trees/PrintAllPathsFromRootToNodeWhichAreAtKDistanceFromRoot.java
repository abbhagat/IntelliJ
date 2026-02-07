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
      return lists;
    }
    findPath(root.left, k - 1, list, lists);
    list.removeLast();
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
      return;
    }
    findPath(root.left,  k - 1, list);
    list.removeLast();
    findPath(root.right, k - 1, list);
    list.removeLast();
  }

  public static void main(String[] args) {
    int[] a = {50, 25, 100, 10, 30, 90, 120};
    Node root = null;
    for (int x : a) {
      root = createBST(root, x);
    }
    List<List<Integer>> lists = findPath(root, 2, new LinkedList<>(), new ArrayList<>());
    System.out.println(lists);

    findPath(root, 2, new LinkedList<>());
  }
}
