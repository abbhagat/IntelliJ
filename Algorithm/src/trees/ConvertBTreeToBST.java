package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static trees.TreeTraversal.inorder;

// Time Complexity: O(n log n)
// Auxiliary Space: O(n)

public class ConvertBTreeToBST {

  private static final List<Integer> list = new ArrayList<>();
  private static int index;

  private static void listToBST(Node root) {  // Inorder
    if (root != null) {
      listToBST(root.left);
      root.num = list.get(index++);
      listToBST(root.right);
    }
  }

  public static void createList(Node root) {   // Inorder
    if (null != root) {
      createList(root.left);
      list.add(root.num);
      createList(root.right);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(30);
    root.right = new Node(15);
    root.left.left = new Node(20);
    root.right.right = new Node(5);
    createList(root);
    Collections.sort(list); // same as list.sort((i,j) -> i - j); or list.sort(Comparator.comparingInt(i -> i));
    listToBST(root);
    inorder(root);
  }
}
