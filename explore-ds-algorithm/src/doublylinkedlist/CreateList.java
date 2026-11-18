package doublylinkedlist;

public class CreateList {

  static Node head, temp, last;
  static int size = 0;

  public static Node createList(int num, Node node) {
    if (node == null) {
      node = new Node(num);
      size++;
    }
    if (head == null) {
      head = node;
    } else {
      temp.next = node;
      node.prev = temp;
    }
    temp = last = node;
    return head;
  }
}
