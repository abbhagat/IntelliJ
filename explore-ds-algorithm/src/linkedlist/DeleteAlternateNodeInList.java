package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time  Complexity: O(n)
// Space Complexity: O(1)
public class DeleteAlternateNodeInList {

  private static void deleteAlternateNode(Node head) {
    Node temp = head;
    while (temp != null && temp.next != null) {
      temp.next  = temp.next.next;
      temp       = temp.next;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    Node head = null;
    for (int x : a) {
      head = add(head, x);
    }
    traverseList(head);
    deleteAlternateNode(head);
    traverseList(head);
  }
}
