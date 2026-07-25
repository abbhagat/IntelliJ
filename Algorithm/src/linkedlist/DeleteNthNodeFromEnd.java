package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time Complexity : O(n)
public class DeleteNthNodeFromEnd {

  private static Node deleteNthNode(Node first, int n) {
    Node head = new Node(-1, first);
    Node temp = head, node = head;
    for (int i = 0; i <= n; i++) {
      temp = temp.next;  // temp will point to the prev on Nth Node after loop completes
    }
    while (temp != null) {
      temp = temp.next;
      node = node.next;
    }
    System.out.println(n + "th Node from End is " + node.next.num);
    node.next = node.next.next;
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
  }
}
