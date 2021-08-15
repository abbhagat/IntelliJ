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

    public static Node findMidPoint(Node first) {
        Node slow = first;
        Node fast = first.next;
        Node prev_slow = slow;
        while (fast != null && fast.next != null) {
            prev_slow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev_slow;
    }
}
