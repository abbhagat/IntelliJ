package linkedlist;

import static linkedlist.LinkList.add;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class IsCyclic {

  public static boolean hasCycle(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] a = {2, 4, 3};
    Node head = null;
    for (int x : a) {
      head = add(head, x);
    }
    LinkList.last.next = head;
    System.out.println(hasCycle(head));
  }
}
