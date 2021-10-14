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

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        System.out.println(MidPointOfLinkedList.findMid(first).num);
    }
}
