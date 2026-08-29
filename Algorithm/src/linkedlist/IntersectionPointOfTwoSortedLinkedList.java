package linkedlist;

import static linkedlist.LinkList.add;

// Time  Complexity : O(m + n)
// Space Complexity : O(1)
public class IntersectionPointOfTwoSortedLinkedList {

  private static Node findIntersectionPoint(Node head1, Node head2) {
    while (head1 != null && head2 != null) {
      if (head1.num == head2.num) {
        return head1;
      }
      if (head1.num < head2.num) {
        head1 = head1.next;
      } else {
        head2 = head2.next;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] a = {3, 6, 9, 15, 30};
    int[] b = {10, 15, 30};
    Node l1 = null, l2 = null;
    for (int x : a) {
      l1 = add(l1, x);
    }
    LinkList.temp = LinkList.last = null;
    for (int x : b) {
      l2 = add(l2, x);
    }
    Node node = findIntersectionPoint(l1, l2);
    System.out.println(node.num);
  }
}
