package linkedlist;

public class LinkList {

    static Node temp, first, last;
    static int size;

    public static Node add(int num, Node node) {
        if (null == node) {
            node = new Node();
            node.num = num;
            node.next = null;
            size++;
        }
        if (null == first) {
            temp = first = node;
        } else {
            temp.next = node;
            temp = node;
            last = temp;
        }
        return first;
    }
}
