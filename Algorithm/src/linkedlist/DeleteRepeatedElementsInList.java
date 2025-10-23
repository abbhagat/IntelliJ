package linkedlist;

import java.util.HashSet;
import java.util.Set;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time complexity: O(n)
public class DeleteRepeatedElementsInList {

  private static void removeDuplicate(Node head) {
    Set<Integer> set = new HashSet<>();
    Node prev = null;
    for (Node temp = head; temp != null; temp = temp.next) {
      if (set.contains(temp.num)) {
        prev.next = temp.next;
      } else {
        set.add(temp.num);
        prev = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 1, 1, 1, 3, 4, 3, 5, 5};
    Node head = null;
    for (int x : a) {
      head = add(head, x);
    }
    removeDuplicate(head);
    traverseList(head);
  }
}
