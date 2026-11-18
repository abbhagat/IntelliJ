package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;
import static util.CommonUtils.swap;

// Time Complexity : O(N), where N denotes the number of nodes in the doubly linked list.
// Auxiliary Space : O(1)
public class ReverseList {

  private static Node reverseList(Node head) {
    Node prev = null, temp = head;
    while (temp != null) {        // swap(node.left, node.right)
      prev = swap(temp);
      temp = temp.prev;
    }
    if (prev != null) {         // Before changing head, check for the cases like empty list and list with only one node
      head = prev.prev;
    }
    return head;
  }

  private static Node reverse(Node node) {
    if (node == null) {
      return null;
    }
    swap(node);
    if (node.prev == null) {
      return node;
    }
    return reverse(node.prev);
  }

  private static Node reverseNode(Node node) {
    if (node == null || node.next == null) {
      if (node != null) {
        node.prev = null;  // the new head's prev should be set to null.
      }
      return node;
    }
    Node head = reverseNode(node.next);
    node.next.next = node;
    node.prev = node.next;
    node.next = null;
    return head;
  }

  public static void main(String[] args) {
    Node head = null;
    int[] a = {1, 2, 3, 4, 5};
    for (int x : a) {
      head = createList(x, null);
    }
    traverseList(head);
    head = reverseList(head);
    traverseList(head);
    head = reverse(head);
    traverseList(head);
  }
}
