package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class PairWithGivenSumInSortedDLL {

  private static void pairSum(Node low, Node high, final int key) {
    while (low != high && low != high.right) {
      int n = low.num + high.num;
      if (n == key) {
        System.out.println("(" + low.num + ", " + high.num + ")");
        low = low.right;
        high = high.left;
      } else if (n < key) {
        low = low.right;
      } else {
        high = high.left;
      }
    }
  }

  public static void main(String[] args) {
    Node head = null;
    int[] a = {1, 2, 3, 4, 5, 6, 8, 9, 10};
    for (int x : a) {
      head = createList(x, null);
    }
    traverseList(head);
    pairSum(head, CreateList.last, 7);
    System.out.println();
    pairSum(head, CreateList.last, 5);
  }
}
