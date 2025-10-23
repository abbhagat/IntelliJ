package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.CreateList.last;
import static doublylinkedlist.TraverseList.traverseList;
import static util.CommonUtils.swap;

public class QuickSort {

  private static Node partition(Node low, Node high) {
    int pivot = high.num;
    Node i = low.left;
    for (Node j = low; j != high; j = j.right) {
      if (j.num <= pivot) {  // j.num > pivot to sort in descending order
        i = (i == null) ? low : i.right;
        swap(i, j);
      }
    }
    i = (i == null) ? low : i.right;
    swap(i, high);
    return i;
  }

  private static void quickSort(Node low, Node high) {
    if (low != null && high != null && low != high && low != high.right) {
      Node pivot = partition(low, high);
      quickSort(low, pivot.left);
      quickSort(pivot.right, high);
    }
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
