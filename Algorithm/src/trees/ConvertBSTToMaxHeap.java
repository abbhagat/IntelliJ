package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.TreeTraversal.inorder;

// Time Complexity: O(n)
// Auxiliary Space: O(n)
public class ConvertBSTToMaxHeap {

  private static final List<Integer> list = new ArrayList<>();
  private static int index;

  private static void listToMaxHeap(Node root) {    // Postorder
    if (root != null) {
      listToMaxHeap(root.left);
      listToMaxHeap(root.right);
      root.num = list.get(index++);
    }
  }

  public static void createList(Node root) {      // Inorder
    if (null != root) {
      createList(root.left);
      list.add(root.num);
      createList(root.right);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(2);
    root.left = new Node(1);
    root.right = new Node(3);
    createList(root);
    System.out.println(list);
    listToMaxHeap(root);
    inorder(root);
  }
}
