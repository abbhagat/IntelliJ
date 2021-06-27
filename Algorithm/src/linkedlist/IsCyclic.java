package linkedlist;

public class IsCyclic {

    public static boolean hasCycle(Node first) {
        Node slow = first;
        Node fast = first.next;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            if (fast == slow || fast.next == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
