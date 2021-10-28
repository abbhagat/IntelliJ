package linkedlist;

import static linkedlist.TraverseList.traverseList;

public class DeleteNthNodeFromEnd {

    private static Node deleteNthNode(Node first, int n) {
        Node head = new Node(-1, first);
        Node slow = head;
        Node fast = head;
        for (int i = 1; i <= n + 1; i++) {
            slow = slow.next;
        }
        while (slow != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = fast.next.next;
        return head.next;
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) {
            first = LinkList.add(first, x);
        }
        traverseList(first);
        System.out.println();
        first = deleteNthNode(first, 7);
        traverseList(first);
    }
}
