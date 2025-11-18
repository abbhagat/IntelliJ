package linkedlist;

import java.util.HashSet;
import java.util.Set;

import static linkedlist.LinkList.add;

// Time complexity : O(m + n)
public class IntersectionPointOfTwoLinkedList {

  private static Node findIntersectionPoint(Node head1, Node head2) {
    Set<Integer> set = new HashSet<>();
    for (Node temp = head1; temp != null; temp = temp.next) {
      set.add(temp.num);
    }
    for (Node temp = head2; temp != null; temp = temp.next) {
      if (set.contains(temp.num)) {
        return temp;
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
    System.out.println(node != null ? "Intersection Point: " + node.num : "No Intersection Point");
  }
}
