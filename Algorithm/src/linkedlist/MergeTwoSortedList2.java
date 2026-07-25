package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class MergeTwoSortedList2 {

  // Time Complexity:  O(m+n)
  private static Node merge(Node head1, Node head2) {
    Node merged = new Node();
    Node temp = merged;
    while (head1 != null && head2 != null) {
      if (head1.num < head2.num) {
        temp.next = head1;
        head1 = head1.next;
        temp = temp.next;
      } else {
        temp.next = head2;
        head2 = head2.next;
        temp = temp.next;
      }
    }
    while (head1 != null) {
      temp.next = head1;
      head1 = head1.next;
      temp = temp.next;
    }
    while (head2 != null) {
      temp.next = head2;
      head2 = head2.next;
      temp = temp.next;
    }
    return merged.next;
  }

  public static void main(String[] args) {
    Node a = null, b = null;
    for (int x : new int[]{1, 3, 2}) {
      a = add(a, x);
    }
    for (int x : new int[]{4, 6, 5}) {
      b = add(b, x);
    }
    traverseList(a);
    traverseList(b);
    traverseList(merge(a, b));
  }
}
