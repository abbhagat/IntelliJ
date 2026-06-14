package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time complexity : O(n)
public class InsertNodeInSortedLinkedList {

  public static Node insertNodeInSortedLinkedList(Node head, int num) {
    if (null == head || num < head.num) {
      return new Node(num, head);
    }
    Node prev = head;
    for (Node temp = head; temp != null && temp.num < num; temp = temp.next) {
      prev = temp;
    }
    Node node = new Node(num, null);
    node.next = prev.next;
    prev.next = node;
    return head;
  }

  public static void main(String[] args) {
    Node head = null;
    for (int x : new int[]{1, 3, 5, 8}) {
      head = add(head, x);
    }
    head = insertNodeInSortedLinkedList(head, 0);
    head = insertNodeInSortedLinkedList(head, 2);
    head = insertNodeInSortedLinkedList(head, 4);
    head = insertNodeInSortedLinkedList(head, 7);
    head = insertNodeInSortedLinkedList(head, 9);
    traverseList(head);
  }
}
