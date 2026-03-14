package linkedlist;

import java.util.List;
import java.util.PriorityQueue;
import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class MergeKSortedList {

  private static Node mergeKSortedList(List<Node> nodeList) {
    PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.num - y.num);
    for (Node node : nodeList) {
      if (node != null)
        pq.add(node);
    }
    Node head = new Node(-1);
    Node temp = head;
    while (!pq.isEmpty()) {
      Node node = pq.poll();
      temp.next = node;
      temp = temp.next;
      if (node.next != null)
        pq.add(node.next);
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
