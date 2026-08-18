package linkedlist;

import static linkedlist.TraverseList.traverseList;

public class CloneLinkedListWithNextAndRandomPointer {

  private static Node clone(Node head) {
    if (head == null) {
      return null;
    }
    // Step 1: Insert cloned nodes between original nodes
    Node temp = head;
    while (temp != null) {
      Node node = new Node(temp.num);  // insert additional node after every node of original list
      node.next = temp.next;
      temp.next = node;
      temp      = temp.next.next;
    }
    // Step 2: Set random pointers of the newly added nodes
    temp = head;
    while (temp != null) {
      if (temp.random != null) {
        temp.next.random = temp.random.next;
      }
      temp = temp.next.next;
    }
    // Step 3: Separate the two lists
    temp       = head;
    Node clone = temp.next;
    while (temp != null) {
      Node copy = temp.next;
      temp.next = temp.next.next;
      if (copy.next != null) {
        copy.next = copy.next.next;
      }
      temp = temp.next;
    }
    return clone;
  }

  public static void main(String[] args) {
    Node node             = new Node(1);
    node.next             = new Node(2);
    node.next.next        = new Node(3);
    node.random           = node.next.next;
    node.next.random      = node;
    node.next.next.random = node.next;
    traverseList(clone(node));
  }
}
