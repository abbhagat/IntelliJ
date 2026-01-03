package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.MidPointOfDoublyLinkedList.findMid;
import static doublylinkedlist.TraverseList.traverseList;

// Time  Complexity: O(n log n)
// Space Complexity: O(1)
public class MergeSort {

  private static Node mergeSort(Node head) {
    if (head == null || head.right == null) {
      return head;
    }
    Node mid   = findMid(head);
    Node head2 = mid.right;
    mid.right  = null;
    Node a = mergeSort(head);
    Node b = mergeSort(head2);
    return merge(a, b);
  }

  private static Node merge(Node a, Node b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    if (a.num < b.num) {
      a.right = merge(a.right, b);
      a.right.left = a;
      a.left = null;
      return a;
    } else {
      b.right = merge(a, b.right);
      b.right.left = b;
      b.left = null;
      return b;
    }
  }

  public static void main(String[] args) {
    Node head = null;
    for (int x : new int[]{1, 3, 5, 2, 4}) {
      head = createList(x, null);
    }
    traverseList(head);
    System.out.println();
    head = mergeSort(head);
    traverseList(head);
  }
}
