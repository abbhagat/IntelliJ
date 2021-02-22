package linkedlist;

public class ReverseLinkedList {

    public static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node first = reverse(node.next);
        node.next.next = null;
        node.next = node;
        return first;
    }
}
