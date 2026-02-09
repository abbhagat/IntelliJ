package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.CreateList.last;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class PairWithGivenSumInSortedDLL {

  private static void pairSum(Node low, Node high, int givenSum) {
    while (low != null && high != null && low != high && low != high.right) {
      int sum = low.num + high.num;
      if (sum == givenSum) {
        System.out.print("(" + low.num + ", " + high.num + ")" + "\t");
        low  = low.right;
        high = high.left;
      } else if (sum < givenSum) {
        low = low.right;
      } else {
        high = high.left;
      }
    }
  }

  public static void main(String[] args) {
    Node head = null;
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int x : a) {
      head = createList(x, null);
    }
    pairSum(head, last, 5);
    System.out.println();
    pairSum(head, last, 7);
    System.out.println();
    pairSum(head, last, 9);
  }
}
