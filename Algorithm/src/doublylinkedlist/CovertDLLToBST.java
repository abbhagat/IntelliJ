package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;

// Time Complexity: O(n)
public class CovertDLLToBST {

  private static Node head;

  private static Node sortedListToBST(int n) {                // n is the total no of nodes in the LinkedList
    if (n <= 0) {
      return null;
    }
    Node left = sortedListToBST(n / 2);               // Recursively construct the left subtree
    Node root = head;                                   // head_ref now refers to middle node, make middle node as root of BST
    root.left = left;                                  // Set pointer to left subtree
    head = head.right;                                // Change head pointer of Linked List for parent recursive calls
    Node right = sortedListToBST(n - n / 2 - 1);  // Recursively construct the right subtree and link it with root.
    root.right = right;
    return root;                                    // The number of nodes in right subtree  is total nodes - nodes in left subtree - 1 (for root)
  }

  private static void preOrder(Node root) {
    if (root != null) {
      System.out.print(root.num + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 3; i++) {
      head = createList(i, null);
    }
    traverseList(head);
    Node root = sortedListToBST(CreateList.size);
    preOrder(root);
  }
}
