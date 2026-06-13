package linkedlist;

import java.util.Set;

import static linkedlist.TraverseList.traverseList;

/**
Create the copy of node 1 and insert it between node 1 & node 2 in the original Linked List,
create a copy of 2 and insert it between 2 & 3. Continue in this fashion, add the copy of N after the Nth node
Now copy the random link in this fashion
original->next->random= original->random->next;
TRAVERSE TWO NODES
This works because original->next is nothing but a copy of the original and Original->random->next is nothing but a copy of the random.
Now restore the original and copy linked lists in this fashion in a single loop.
original->next = original->next->next;
copy->next = copy->next->next;
Ensure that original->next is NULL and return the cloned list
*/
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
      temp      = node.next;
    }

    // Step 2: Set random pointers
    temp = head;
    while (temp != null) {
      if (temp.random != null) {
        temp.next.random = temp.random.next;  // Since every copied node is immediately after its original node.
      }
      temp = temp.next.next;
    }
    // Step 3: Separate the two lists
    temp = head;
    while (temp != null) {
      Node copy = temp.next;
      temp.next = copy.next;
      if (copy.next != null) {
        copy.next = copy.next.next;
      }
      temp = temp.next;
    }
    return head.next;
  }

  public static void main(String[] args) {
    Node node      = new Node(1);
    node.next      = new Node(2);
    node.next.next = new Node(3);
    node.random = node.next.next;
    node.next.random = node;
    node.next.next.random = node.next;
    traverseList(clone(node));
  }
}
