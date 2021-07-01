package linkedlist;

public class ReverseList {

    public static Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node first = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return first;
    }
}
