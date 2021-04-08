package linkedlist;

public class MidPointOfLinkedList {

    static Node midList(Node first) {
        Node slow = first;
        Node fast = first.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node midItrList(Node head) {
        Node temp = head;
        for (int i = 0; i < LinkList.size / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
