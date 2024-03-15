package linkedlist;

public class LinkList {

    static Node temp, last;

    public static Node add(Node first, int num) {
        Node node = new Node(num, null);
        if (first == null) {
             first = node;
        } else {
            temp.next = node;
            last = node;
        }
        temp = node;
        return first;
    }
}
