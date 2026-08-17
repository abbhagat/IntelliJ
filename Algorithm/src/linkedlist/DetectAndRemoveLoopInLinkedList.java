package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class DetectAndRemoveLoopInLinkedList {

  private static void detectAndRemoveLoop(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        removeCycle(head, fast);
        return;
      }
    }
  }

  private static void removeCycle(Node head, Node fast) {
    Node slow = head;
    while (slow.next != fast.next) {  // Find the node just before the start of the loop
      slow = slow.next;
      fast = fast.next;
    }
    fast.next = null;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    Node head = null;
    for (int x : a) {
      head = add(head, x);
    }
    head.next.next.next = head.next.next;
    detectAndRemoveLoop(head);
    traverseList(head);
  }
}
