package linkedlist;

public class LinkList {

    static Node temp, last;

    public static Node add(Node first, int num) {
        Node node = new Node(num, null);
        if(null == first) {
            temp = first = node;
        } else {
            temp.next = node;
            temp = node;
            last = temp;
        }
        return first;
    }
}
