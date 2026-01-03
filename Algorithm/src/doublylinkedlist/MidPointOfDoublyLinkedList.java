package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;

public class MidPointOfDoublyLinkedList {

  public static Node findMid(Node head) {
    Node slow = head, fast = head.right;
    while (fast != null && fast.right != null) {
      slow = slow.right;
      fast = fast.right.right;
    }
    return slow;
  }

  public static void main(String[] args) {
    Node head = null;
    for (int x : new int[]{1, 3, 5, 2, 4}) {
      head = createList(x, null);
    }
    traverseList(head);
    System.out.println("Mid Point Is : " + findMid(head).num);
  }
}
