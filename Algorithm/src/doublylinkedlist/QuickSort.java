package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.CreateList.last;
import static doublylinkedlist.TraverseList.traverseList;
import static util.CommonUtils.swap;

public class QuickSort {

  private static void quickSort(Node low, Node high) {
    if (low != null && high != null && low != high && low != high.next) {
      Node pivot = partition(low, high);
      quickSort(low, pivot.prev);
      quickSort(pivot.next, high);
    }
  }

  private static Node partition(Node low, Node high) {
    int pivot = high.num;
    Node i = low.prev, j;
    for (j = low; j != high; j = j.next) {
      if (j.num <= pivot) {  // j.num > pivot to sort in descending order
        i = (i == null) ? low : i.next;
        swap(i, j);
      }
    }
    i = (i == null) ? low : i.next;
    swap(i, j);
    return i;
  }

  public static void main(String[] args) {
    Node head = null;
    int[] a = {1, 3, 5, 2, 4, 7, 10, 6, 9, 8};
    for (int x : a) {
      head = createList(x, null);
    }
    traverseList(head);
    quickSort(head, last);
    traverseList(head);
  }
}
