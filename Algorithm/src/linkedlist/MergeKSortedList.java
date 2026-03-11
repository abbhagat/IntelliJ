package linkedlist;

import java.util.List;
import java.util.PriorityQueue;
import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class MergeKSortedList {

  private static Node mergeKSortedList(List<Node> nodeList) {
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.num - b.num);
    for (Node node : nodeList) {
      if (node != null)
        pq.add(node);
    }
    Node head = new Node(0);
    Node temp = head;
    while (!pq.isEmpty()) {
      Node min = pq.poll();
      temp.next = min;
      temp = temp.next;
      if (min.next != null)
        pq.add(min.next);
    }
    return head.next;
  }

  public static void main(String[] args) {
    Node a = null, b = null, c = null;
    for (int x : new int[]{1, 3}) {
      a = add(a, x);
    }
    for (int x : new int[]{2, 4}) {
      b = add(b, x);
    }
    for (int x : new int[]{5}) {
      c = add(c, x);
    }
    List<Node> nodeList = List.of(a, b, c);
    Node head = mergeKSortedList(nodeList);
    traverseList(head);
  }
}
