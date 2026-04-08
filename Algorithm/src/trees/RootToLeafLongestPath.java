package trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafLongestPath {

  public static List<Integer> longestPath(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> leftList  = longestPath(root.left);
    List<Integer> rightList = longestPath(root.right);
    boolean b = leftList.size() > rightList.size() ? leftList.add(root.num) : rightList.add(root.num);
    return leftList.size() > rightList.size() ? leftList : rightList;
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
    System.out.println(longestPath(root));
  }
}
