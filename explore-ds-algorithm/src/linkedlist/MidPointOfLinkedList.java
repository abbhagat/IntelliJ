package linkedlist;

import static linkedlist.LinkList.add;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class MidPointOfLinkedList {

  public static Node findMid(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static Node findPrevMidPoint(Node head) {
    Node slow = head, prev = head, fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    return prev;
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
