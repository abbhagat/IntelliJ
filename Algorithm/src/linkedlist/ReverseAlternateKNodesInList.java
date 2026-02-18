package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class ReverseAlternateKNodesInList {

  private static Node reverse(Node head, int k) {
    Node temp = head, prev = null;
    int count = 1;
    while (temp != null && count <= k) {   // reverse first k nodes of the linked list
      Node next = temp.next;
      temp.next = prev;
      prev = temp;
      temp = next;
      count++;
    }
    if (head != null) {        // head points to the 1st node of list i.e 1. So change next of head to (k+1)th head
      head.next = temp;
    }
    // We do not want to reverse next k nodes. So move the current pointer to skip next k nodes
    count = 1;
    while (temp != null && count < k) {
      temp = temp.next;
      count++;
    }
    // Recursively call for the list starting from current->next And make rest of the list as next of first head
    if (temp != null) {
      temp.next = reverse(temp.next, k);
    }
    return prev;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Node first = null;
    for (int x : a) {
      first = add(first, x);
    }
    traverseList(first);
    first = reverse(first, 3);
    traverseList(first);
  }
}
