package linkedlist;

import static linkedlist.TraverseList.traverseList;

 // Time Complexity : O(n)
// Space Complexity : O(1)
public class ReverseList {

  private static Node reverse(Node head) {
    Node temp = head, prev = null;
    while (temp != null) {
      Node node = temp.next;
      temp.next = prev;
      prev = temp;
      temp = node;
    }
    return prev;
  }

  public static Node reverseList(Node node) {
    if (node == null || node.next == null) {
      return node;
    }
    Node head = reverseList(node.next);
    node.next.next = node;
    node.next = null;
    return head;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    Node first = null;
    for (int x : a) {
      first = LinkList.add(first, x);
    }
    traverseList(first);
    first = reverseList(first);
    traverseList(first);
    first = reverse(first);
    traverseList(first);
  }
}
