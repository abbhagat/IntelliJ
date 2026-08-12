package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time Complexity : O(n)
public class DeleteNthNodeFromEnd {

  private static Node deleteNthNode(Node first, int n) {
    Node head = new Node(-1, first);
    Node slow = head, fast = head;
    for (int i = 1; i <= n + 1; i++) {
      slow = slow.next;  // slow will point to the prev of Nth Node after loop completes
    }
    while (slow != null) {
      slow = slow.next;
      fast = fast.next;  // fast will point to the Nth Node after loop completes
    }
    System.out.println(n + "th Node from End is " + fast.next.num);
    fast.next = fast.next.next;
    return head.next;
  }

  public static void main(String[] args) {
    Node first = null;
    for (int x : new int[]{1, 2, 3, 4, 5}) {
      first = add(first, x);
    }
    traverseList(first);
    System.out.println();
    first = deleteNthNode(first, 2);
    traverseList(first);
    first = deleteNthNode(first, 1);
    traverseList(first);
  }
}
