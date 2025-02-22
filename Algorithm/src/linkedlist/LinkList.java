package linkedlist;

public class LinkList {

    static Node temp, last;

    public static Node add(Node head, int num) {
        Node node = new Node(num, null);
        if (head == null) {
             head = node;
        } else {
            temp.next = node;
            last = node;
        }
        temp = node;
        return head;
    }
}
