package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

/**
 * If the linked list is 5->10->25->45->31->16->23->51 and k=3
 * Then linked should be converted to 5->10->16->45->31->25->23->51
 * Boundary cases had to be handled properly.
 */
public class ExchangeKthNodeFromStartAndKthNodeFromEnd {

  private static Node nthNodeFromEnd(Node head, int n) {
    Node slow = head, fast = head;
    for (int i = 0; i <= n; i++) {
      slow = slow.next;
    }
    while (slow != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return fast;
  }

  private static Node exchangeKthNode(Node first, final int n) {
    Node head = new Node(-1, first);
    Node temp = head, prev = head;
    for (int i = 1; i <= n; i++) {
      prev = temp;
      temp = temp.next;
    }
    Node prev_nthNode = nthNodeFromEnd(first, n);
    Node nthNode = prev_nthNode.next;
    Node temp2 = nthNode.next;
    prev.next = nthNode;
    nthNode.next = temp.next;
    prev_nthNode.next = temp;
    temp.next = temp2;
    return head.next;
  }

  public static void main(String[] args) {
    Node first = null;
    for (int x : new int[]{1, 2, 3, 4, 5, 6, 7}) {
      first = add(first, x);
    }
    first = exchangeKthNode(first, 1);
    traverseList(first);
    first = exchangeKthNode(first, 2);
    traverseList(first);
    first = exchangeKthNode(first, 3);
    traverseList(first);
  }
}
