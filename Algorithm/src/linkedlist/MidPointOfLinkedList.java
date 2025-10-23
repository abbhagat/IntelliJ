package linkedlist;

import static linkedlist.LinkList.add;

public class MidPointOfLinkedList {

  public static Node findMid(Node head) {
    if (head == null) {
      return null;
    }
    Node slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static Node findPrevMidPoint(Node head) {
    if (head == null) {
      return null;
    }
    Node slow = head, prev_slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      prev_slow = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    return prev_slow;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6};
    Node first = null;
    for (int x : a) {
      first = add(first, x);
    }
    System.out.println(findMid(first).num);
  }
}
