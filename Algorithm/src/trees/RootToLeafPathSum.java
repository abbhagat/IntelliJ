package trees;

import java.util.LinkedList;

public class RootToLeafPathSum {

  public static void rootToLeafPathSum(Node root, int sum) {
    if (root == null) {
      return;
    }
    sum += root.num;
    if (root.left == null && root.right == null) {
      System.out.println(sum);
      return;
    }
    rootToLeafPathSum(root.left,  sum);
    rootToLeafPathSum(root.right, sum);
  }

  public static void rootToLeafPathSum(Node root, LinkedList<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.num);
    if (root.left == null && root.right == null) {
      System.out.println(list.stream().reduce(Integer::sum).get());
      return;
    }
    rootToLeafPathSum(root.left,  list);
    list.removeLast();
    rootToLeafPathSum(root.right, list);
    list.removeLast();
  }

  public static void main(String[] args) {
    /*
                  4
                 / \
                2   6
               / \  /\
              1  3  5 7
    */
    Node root        = new Node(4);
    root.left        = new Node(2);
    root.right       = new Node(6);
    root.left.left   = new Node(1);
    root.left.right  = new Node(3);
    root.right.left  = new Node(5);
    root.right.right = new Node(7);
    rootToLeafPathSum(root, 0);
    System.out.println();
    rootToLeafPathSum(root, new LinkedList<>());
  }
}
