package linkedlist;

import static linkedlist.LinkList.add;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class IsCyclic {

  public static boolean hasCycle(Node head) {
    Node slow = head, fast = head.next;
    while (true) {
      if (fast == null || fast.next == null) {
        return false;
      }
      if (fast == slow || fast.next == slow) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
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
