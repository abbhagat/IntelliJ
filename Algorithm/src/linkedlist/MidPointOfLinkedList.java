package linkedlist;

public class MidPointOfLinkedList {

    public static Node findMid(Node first) {
        Node slow = first;
        Node fast = first.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
