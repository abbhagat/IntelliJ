package linkedlist;

public class IsCyclic {

    public static boolean isCyclic(Node first) {
        Node slow = first;
        Node fast = first.next;
        while (true) {
            if (slow == fast || slow == fast.next) {
                return true;
            }
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
